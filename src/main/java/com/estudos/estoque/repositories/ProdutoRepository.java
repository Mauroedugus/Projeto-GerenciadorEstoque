package com.estudos.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.estudos.estoque.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}