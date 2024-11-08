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
import org.lc.modelo.Utilitaria;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@WebServlet("/AgregarUsuario")
public class AgregarUsusarioServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recibir datos del formulario
        String nombre = req.getParameter("nombre");
        String email = req.getParameter("email");
        String usuarioNombre = req.getParameter("usuario");
        String clave = req.getParameter("clave");
        String fechaNacStr = req.getParameter("fechaN");

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

        String animal= null;

        if (horoscopo.isPresent()) {
            animal = horoscopo.get().getAnimal();
            System.out.println("Animal del Horoscopo: " +animal);
        }else{
            animal= "Los lobos";
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Horoscopo no encontrado para el: " +fNacimiento);
        }

        Usuario usuario = new Usuario(null,nombre,usuarioNombre,email,fNacimiento,clave,animal);
        UsuarioDaoImp usuarioDao = new UsuarioDaoImp();

        Boolean respuesta =usuarioDao.agregar(usuario);

        if(respuesta) {
            req.setAttribute("registerMessage","Usuario agregado exitosamente, Ingresa con tus Datos");
        }else {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al incluir sus datos   ACA ES DONDE NO ME ESTA INCLUYENDO");
        }
        resp.sendRedirect("/HoroscopoChino/login.jsp");
    }

}






























