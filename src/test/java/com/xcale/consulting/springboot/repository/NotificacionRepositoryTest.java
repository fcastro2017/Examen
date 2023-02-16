package com.xcale.consulting.springboot.repository;

import com.xcale.consulting.springboot.DemoApplication;
import com.xcale.consulting.springboot.model.Usuario;
import com.xcale.consulting.springboot.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = DemoApplication.class)
class NotificacionRepositoryTest {

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Test
    public void getNotificaciones() {

        List<Usuario> usuarios = usuarioService.getNotificaciones();

        usuarios.forEach(usuario ->
                assertEquals(usuario.getNombreUsuario(),"Juanito"));
    }

}