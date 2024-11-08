package org.lc.dao;

import org.lc.modelo.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioDao {


    List<Usuario> listarUsuario();
    Optional<Usuario> porId(Long id);
    Boolean ActualizarUsuario(Usuario u);
    Boolean agregar( Usuario u);
    Boolean eliminar(Long id);


 }
