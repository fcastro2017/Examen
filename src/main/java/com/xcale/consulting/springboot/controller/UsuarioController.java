package com.xcale.consulting.springboot.controller;

import com.xcale.consulting.springboot.dto.UsuarioDto;
import com.xcale.consulting.springboot.model.Usuario;
import com.xcale.consulting.springboot.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // build create user REST API
    @PostMapping
    public ResponseEntity<UsuarioDto> createUser(@RequestBody Usuario usuario){


        UsuarioDto usuarioDto = new UsuarioDto();

        UUID uuid = UUID.randomUUID();
        usuarioDto.setId(String.valueOf(uuid));
        List<Usuario> usuarios = usuarioService.getUsuarios();
        usuarios.forEach(usuario1 -> {

            if (usuario.getTelefono().equals(usuario1.getTelefono())) {
                try {
                    throw new Exception("Usuario ya registrado");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        usuarioDto.setToken(String.valueOf(uuid));
        usuarioDto.setIsActive(true);
        Usuario created = usuarioService.crearUsuario(usuario);
        usuarioDto.setCreated(created.getCreated());
        usuarioDto.setModified(created.getModified());
        usuarioDto.setLastLogin(created.getLastLogin());
        return new ResponseEntity<UsuarioDto>(usuarioDto, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Usuario> getNotificacion() {
        List<Usuario> usuarios = usuarioService.getNotificaciones();
        return usuarios;
    }
}
