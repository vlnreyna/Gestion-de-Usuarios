package com.vlndev.gestion_usuarios.controller;

import com.vlndev.gestion_usuarios.models.Usuario;
import com.vlndev.gestion_usuarios.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioRepository ur;

    public UsuarioController(UsuarioRepository ur) {
        this.ur = ur;
    }

    @GetMapping("/todos")
    public List<Usuario> getUsuarios() {
        return ur.findAll();
    }

    @PostMapping("/insertarUsuario")
    public Usuario insertUsuario(@RequestBody Usuario u) {
        return ur.save(u);
    }
}
