package com.xcale.consulting.springboot.service;

import com.xcale.consulting.springboot.model.Usuario;
import com.xcale.consulting.springboot.repository.NotificacionRepository;
import com.xcale.consulting.springboot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImp implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository ;

    @Autowired
    private NotificacionRepository notificacionRepository ;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    @Override
    public List<Usuario> getNotificaciones() {
        List<Usuario> usuarios= notificacionRepository.getNotificaciones();
        return usuarios;
    }
}
