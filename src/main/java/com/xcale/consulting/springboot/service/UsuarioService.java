package com.xcale.consulting.springboot.service;

import com.xcale.consulting.springboot.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario crearUsuario(Usuario usuario);
    public List<Usuario> getUsuarios();
    public List<Usuario> getNotificaciones();

}
