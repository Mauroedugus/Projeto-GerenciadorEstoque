package com.estudos.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.estudos.estoque.models.EntradaProduto;

public interface EntradaProdutoRepository extends JpaRepository<EntradaProduto, Integer> {

}