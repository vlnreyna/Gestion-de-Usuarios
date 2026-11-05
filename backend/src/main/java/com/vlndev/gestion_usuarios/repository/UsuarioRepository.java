package com.vlndev.gestion_usuarios.repository;

import com.vlndev.gestion_usuarios.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
