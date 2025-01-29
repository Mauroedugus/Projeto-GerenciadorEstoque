package com.estudos.estoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.estudos.estoque.repositories.CategoriaRepository;
import com.estudos.estoque.models.Categoria;

@Component
public class TesteConexao implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void run(String... args) throws Exception {
        Categoria categoria = new Categoria();
        categoria.setNome("Teste");
        categoria.setDescricao("Teste de conexão");
        categoriaRepository.save(categoria);
        System.out.println("Registro salvo com sucesso!");
    }
}

