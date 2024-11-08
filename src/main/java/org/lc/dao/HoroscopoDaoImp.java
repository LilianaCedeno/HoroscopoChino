package org.lc.dao;

import org.lc.modelo.Horoscopo;
import org.lc.modelo.Usuario;
import org.lc.procesaconexion.ConexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class HoroscopoDaoImp implements IHoroscopoDao {

    private Connection conectar() throws SQLException, ClassNotFoundException {
        return ConexionBD.getInstance();
    }

    @Override
    public List<Horoscopo> mostrarHoroscopo() {

        List<Horoscopo> listaHoroscopo = new ArrayList<>();
        String sql = "SELECT * FROM Horoscopo";

        try (Statement st = conectar().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Horoscopo horoscopo = new Horoscopo();
                horoscopo.setAnimal(rs.getString("animal"));
                horoscopo.setDescripcion(rs.getString("des_hor"));
                horoscopo.setFechaInicio(rs.getDate("fecha_ini"));
                horoscopo.setFechaFin(rs.getDate("fecha_fin"));
                horoscopo.setLugar(rs.getString("lugar"));

                listaHoroscopo.add(horoscopo);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return listaHoroscopo;
    }

    @Override
    public Optional<Horoscopo> obtenerHoroscopo(Date fechaNacimiento) {
        Optional<Horoscopo> optionalHoroscopo = Optional.empty();
        String sql = "SELECT * FROM horoscopo WHERE '" + fechaNacimiento +"' BETWEEN fecha_ini AND fecha_fin;";

        try (Statement st = conectar().createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                Horoscopo horoscopo = new Horoscopo();
                horoscopo.setAnimal(rs.getString("animal"));
                horoscopo.setDescripcion(rs.getString("des_hor"));
                horoscopo.setFechaInicio(rs.getDate("fecha_ini"));
                horoscopo.setFechaFin(rs.getDate("fecha_fin"));
                horoscopo.setLugar(rs.getString("lugar"));

                optionalHoroscopo = Optional.of(horoscopo);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return optionalHoroscopo;
    }

}
