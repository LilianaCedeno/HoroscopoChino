package org.lc.servlets;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.lc.dao.UsuarioDaoImp;

import java.io.IOException;

@WebServlet("/EliminarServlet")
public class EliminarUsuarioServlet extends HttpServlet {

    public EliminarUsuarioServlet() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsuarioDaoImp usuarioDao = new UsuarioDaoImp();
        String id = req.getParameter("id");

        Boolean respuesta = usuarioDao.eliminar(Long.parseLong(id));

        if (respuesta) {
            req.setAttribute("Mensaje", "El usuario se ha eliminado exitosamente");
        } else {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el usuario");
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/Usuarios");
        dispatcher.forward(req, resp);
    }


}
