package org.lc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.lc.dao.HoroscopoDaoImp;
import org.lc.modelo.Horoscopo;
import org.lc.modelo.Utilitaria;

import java.io.IOException;
import java.sql.Date;
import java.util.Optional;

@WebServlet("/horoscopoServlet")
public class CosultaHoroscopoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilitaria util = new Utilitaria();
        HoroscopoDaoImp horoscopoDao = new HoroscopoDaoImp();
        String fecha_nacimientoStr = req.getParameter("fecha_nacimiento");
        System.out.println(fecha_nacimientoStr);
        Date fecha = Date.valueOf(fecha_nacimientoStr);

        Horoscopo horoscopoUsuario = null;
        horoscopoUsuario = horoscopoDao.obtenerHoroscopo(fecha).orElse(null);

        req.setAttribute("horoscopo", horoscopoUsuario);
        getServletContext().getRequestDispatcher("/horoscopo.jsp").forward(req, resp);
    }

}

