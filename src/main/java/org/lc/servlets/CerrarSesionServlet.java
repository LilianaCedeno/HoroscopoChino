package org.lc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.lc.dao.UsuarioDaoImp;
import org.lc.modelo.Usuario;
import org.lc.modelo.Utilitaria;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/CerrarSesion")
public class CerrarSesionServlet extends HttpServlet {

    public CerrarSesionServlet() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilitaria util = new Utilitaria();
        Optional<String> optionalUsuario = util.obtenerUsuario(req);
        if (optionalUsuario.isPresent()) {
            HttpSession session = req.getSession();
            session.invalidate();
            System.out.println("El usuario " + optionalUsuario.get() + " ha cerrado sesión.");
            req.setAttribute("Mensaje", "Has cerrado sesión correctamente.");
        }

        resp.sendRedirect("/HoroscopoChino/login.jsp");
    }

}



