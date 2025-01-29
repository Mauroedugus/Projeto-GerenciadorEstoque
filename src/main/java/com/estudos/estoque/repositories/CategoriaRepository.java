package com.estudos.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.estoque.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}