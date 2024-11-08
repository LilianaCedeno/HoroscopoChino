package org.lc.procesaconexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static ConexionBD con;
    private static Connection c;
    private static String url;
    private static String usuario;
    private static String clave;

    private ConexionBD() {

        try {
            url = "jdbc:mysql://localhost:3306/horoscopo?serverTimezone=America/Santiago";
            usuario = "root";
            clave = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException | ClassNotFoundException e) {

        }
    }


    public static Connection getInstance() throws SQLException, ClassNotFoundException {
        if (con == null) {
            con = new ConexionBD();
        }
        return c;
    }


}
