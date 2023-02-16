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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = DemoApplication.class)
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;


    @Test
    public void saveUsuarios() {

       Usuario usuario = getUsuario();
       usuarioRepository.save(usuario);

        List<Usuario> result = new ArrayList<>();
        usuarioRepository.findAll().forEach(e -> result.add(e));
        assertEquals(result.size(), 12);
    }

    private Usuario getUsuario() {
        Usuario usuario = new Usuario();

        usuario.setNombreUsuario("Miguel");
        usuario.setTelefono("9819736458");
        return usuario;
    }


}