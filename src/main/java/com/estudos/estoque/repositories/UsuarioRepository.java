package com.estudos.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.estudos.estoque.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}