package org.lc.dao;
import org.lc.modelo.Usuario;
import org.lc.procesaconexion.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDaoImp implements IUsuarioDao {

    private Connection conectar() throws SQLException, ClassNotFoundException {
        return ConexionBD.getInstance();
    }

    @Override
    public List<Usuario> listarUsuario() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario;";

        try (Statement st = conectar().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {

                Usuario u = new Usuario(
                rs.getLong("id_usu"),
                rs.getString("nombre_usu"),
                rs.getString("nom_usu"),
                rs.getString("email_usu"),
                rs.getDate("fec_nac"),
                rs.getString("cla_usu"),
                rs.getString("ani_usu"));

                usuarios.add(u);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public Optional<Usuario> porId(Long id) {
       Optional<Usuario> optionalUsuario = Optional.empty();
        String sql = "SELECT * FROM usuario WHERE id_usu = " + id +";";

        try (PreparedStatement st = conectar().prepareStatement(sql);
        ResultSet rs = st.executeQuery(sql)) {

                if (rs.next()) {
                    optionalUsuario = Optional.of(new Usuario(
                    rs.getLong("id_usu"),
                    rs.getString("nombre_usu"),
                    rs.getString("nom_usu"),
                    rs.getString("email_usu"),
                    rs.getDate("fec_nac"),
                    rs.getString("cla_usu"),
                    rs.getString("ani_usu")));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return optionalUsuario;
    }

    @Override
    public Boolean agregar(Usuario u) {
        String sql = "INSERT INTO usuario (nombre_usu, nom_usu, email_usu, fec_nac, cla_usu, ani_usu) VALUES (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement ps = conectar().prepareStatement(sql)) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getNomUsuario());
            ps.setString(3, u.getEmail());
            ps.setDate(4, new java.sql.Date(u.getFechaNacimiento().getTime()));
            ps.setString(5, u.getPassword());
            ps.setString(6, u.getAnimal());
            ps.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean eliminar(Long id) {
        String sql = "DELETE FROM usuario WHERE id_usu = " + id + ";";
        try (Statement st = conectar().createStatement()) {
            st.execute(sql);
            return true;

        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }

    }


    @Override
    public Boolean ActualizarUsuario(Usuario u) {
        String sql = "UPDATE usuario SET nombre_usu = ?, nom_usu = ?, email_usu = ?, fec_nac = ?, cla_usu = ?, ani_usu = ? WHERE id_usu = ?;";
        try (PreparedStatement ps = conectar().prepareStatement(sql)) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getNomUsuario());
            ps.setString(3, u.getEmail());
            ps.setDate(4, new java.sql.Date(u.getFechaNacimiento().getTime()));
            ps.setString(5, u.getPassword());
            ps.setString(6, u.getAnimal());
            ps.setLong(7, u.getId());
            ps.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Optional<Usuario> buscarPorNombre(String nombre) {
        String sql = "SELECT * FROM usuario WHERE nombre_usu = ?";
        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getLong("id_usu"),
                        rs.getString("nombre_usu"),
                        rs.getString("nom_usu"),
                        rs.getString("email_usu"),
                        rs.getDate("fec_nac"),
                        rs.getString("cla_usu"),
                        rs.getString("ani_usu")
                );
                return Optional.of(usuario);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
