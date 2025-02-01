package com.estudos.estoque.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.estoque.models.Produto;
import com.estudos.estoque.servicies.ProdutoService;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping("/register")
	public Produto registerProduto(@RequestBody Produto produto) {
		return produtoService.save(produto);
	}
	
	@PutMapping("/edit/id/{id}")
	public Produto editProduto(@PathVariable int id,@RequestBody Produto produto) {
		return produtoService.edit(id, produto);
	}

	@DeleteMapping("/delete/id/{id}")
	public void deleteProduto(@PathVariable int id) {
		produtoService.deleteById(id);
	}
	
	@GetMapping("/get/id/{id}")
	public Produto findProdutoById(@PathVariable int id) {
		return produtoService.findById(id);
	}
	
	@GetMapping("/seach")
	public List<Produto> seachprodutos(@RequestParam String seach) {
		return produtoService.search(seach);
	}
	
}
