package org.lc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.lc.dao.UsuarioDaoImp;
import org.lc.modelo.Usuario;
import org.lc.modelo.Utilitaria;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/Usuarios")
public class ListarUsuariosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Utilitaria util = new Utilitaria();
            UsuarioDaoImp usuarioDaoImp = new UsuarioDaoImp();

            Optional<String> optionalUsuario = util.obtenerUsuario(req);
            List<Usuario> usuarioList = usuarioDaoImp.listarUsuario();

            req.setAttribute("usuarioList", usuarioList);
            req.setAttribute( "usuario",optionalUsuario.orElse(null));


            getServletContext().getRequestDispatcher("/listarUsuario.jsp").forward(req, resp);
    }



}
