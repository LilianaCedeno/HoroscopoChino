package org.lc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.lc.dao.HoroscopoDaoImp;
import org.lc.dao.UsuarioDaoImp;
import org.lc.modelo.Horoscopo;
import org.lc.modelo.Usuario;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@WebServlet({"/ActualizarServlet","/ActulizaGet"})
public class ActualizarUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.valueOf(req.getParameter("id"));
        String nombre = req.getParameter("nombre");
        String nomUsuario = req.getParameter("usuario");
        String email = req.getParameter("email");
        String fechaNacStr = req.getParameter("fechaN");
        String password = req.getParameter("clave");



        LocalDate fechaNac;
        try {
            fechaNac = LocalDate.parse(fechaNacStr);
        } catch (DateTimeParseException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato de fecha inválido");
            return;
        }

        Date fNacimiento = Date.valueOf(fechaNac);


        HoroscopoDaoImp horoscopoDao = new HoroscopoDaoImp();
        Optional<Horoscopo> horoscopo = horoscopoDao.obtenerHoroscopo(fNacimiento);

        String animal=null;

        if (horoscopo.isPresent()) {
            animal = horoscopo.get().getAnimal();
            System.out.println("Animal del Horoscopo: " +animal);
        }else{
            animal= "Los lobos";
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Horoscopo no encontrado para el: " +fNacimiento);
        }
        Usuario usuario = new Usuario(id,nombre,nomUsuario,email,fNacimiento,password,animal);;
        UsuarioDaoImp usuarioDao = new UsuarioDaoImp();

        boolean respuesta = usuarioDao.ActualizarUsuario(usuario);

        if (respuesta) {
            req.setAttribute("mensaje","Usuario Actualizado");
            resp.sendRedirect(req.getContextPath() + "/Usuarios");

        } else {
            req.setAttribute("mensaje", "No se pudo actualizar el usuario.");
            getServletContext().getRequestDispatcher("/Usuarios").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.valueOf(req.getParameter("id"));
        UsuarioDaoImp usuarioDao = new UsuarioDaoImp();

        Optional<Usuario> optionalUsuario = usuarioDao.porId(id);

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            req.setAttribute("usuario", usuario);
            getServletContext().getRequestDispatcher("/actualizarUsuario.jsp").forward(req, resp);
        } else {

            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Usuario no encontrado");

        }

    }
}

