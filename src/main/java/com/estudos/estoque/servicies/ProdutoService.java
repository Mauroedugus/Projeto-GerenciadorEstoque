package com.estudos.estoque.servicies;

import java.util.Collections;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.estoque.exceptions.ProductNotFoundException;
import com.estudos.estoque.models.Produto;
import com.estudos.estoque.repositories.ProdutoRepository;

@Service	
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto save(Produto produto) { 
		return produtoRepository.save(produto);
	}
	
	public Produto edit(int id, Produto produto) {
		Produto produtoOriginal = findById(id);
		
		produtoOriginal.setNome(produto.getNome());
		produtoOriginal.setQuantidade(produto.getQuantidade());
		produtoOriginal.setValor_custo(produto.getValor_custo());
		produtoOriginal.setValor_venda(produto.getValor_venda());
		produtoOriginal.setDescricao(produto.getDescricao());
		produtoOriginal.setCategoria(produto.getCategoria());
		
		return produtoRepository.save(produtoOriginal);
		
	}
	
	public void deleteById(int id) {
		produtoRepository.deleteById(id);
	}
	
	public Produto findById(int id) {
		return produtoRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Produto não encontrado"));
	}
	
	public List<Produto> search(String response) {
		try {
			//Transforma a pesquisa em int
			int id = Integer.parseInt(response);
			
			//pesquisar sobre functions utilizadas
			return produtoRepository.findById(id)
	                .map(List::of)
	                .orElse(Collections.emptyList());
			
		//exception caso a conversão para numero não seja valida
		}catch (NumberFormatException  e) {
			return produtoRepository.findByNomeContainingIgnoreCase(response);
		}
	}
}
