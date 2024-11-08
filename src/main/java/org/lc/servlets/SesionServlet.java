package org.lc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.lc.modelo.Utilitaria;
import org.lc.procesaconexion.ConexionBD;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Optional;

@WebServlet({"/InicioSesion", "/InicioSesionGet"})
public class SesionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String u = req.getParameter("usuario");
        String c = req.getParameter("clave");
        Date fecha = new Date();

        String sql = "SELECT * FROM usuario WHERE nom_usu = '" + u + "' AND cla_usu = '" + c + "';";
        try (Statement st = ConexionBD.getInstance().createStatement();
             ResultSet rs = st.executeQuery(sql)
        ) {
            if (rs.next()) {
                HttpSession session = req.getSession();
                session.setAttribute("usuario", rs.getString("nom_usu"));
                session.setAttribute("fecha_nac", rs.getString("fec_nac"));
                session.setAttribute("id", rs.getString("id_usu"));

                resp.sendRedirect(req.getContextPath() + "/bienvenido.jsp");
            } else {
                req.setAttribute("mensajeError", "Usuario o clave incorrectos. Inténtelo nuevamente.");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            req.setAttribute("error", "Ocurrió un error al procesar su solicitud. Inténtelo nuevamente.");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        Utilitaria util = new Utilitaria();
        Optional<String> optionalUsuario = util.obtenerUsuario(req);

        if (optionalUsuario.isPresent()) {
            req.setAttribute("usuario", optionalUsuario.get());
            getServletContext().getRequestDispatcher("/bienvenido.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
