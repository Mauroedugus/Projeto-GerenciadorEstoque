package com.estudos.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.estudos.estoque.models.SaidaProduto;

public interface SaidaProdutoRepository extends JpaRepository<SaidaProduto, Integer> {

}