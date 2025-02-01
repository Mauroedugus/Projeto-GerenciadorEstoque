package com.estudos.estoque.servicies;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.stereotype.Service;

import com.estudos.estoque.models.Produto;
import com.estudos.estoque.repositories.ProdutoRepository;

@Service	
public class ProdutoServiceTest {
	
	@Mock
	private ProdutoRepository produtoRepository;
	
	@InjectMocks
	private ProdutoService produtoService;
	
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }
	
	@Test
	public void save() { 
		Produto produto = new Produto();
        produto.setId(1);
        produto.setNome("Produto Teste");
        produto.setQuantidade(10);
        produto.setValor_custo(20.0);
        produto.setValor_venda(30.0);
		
        when(produtoRepository.save(produto)).thenReturn(produto);
        
        Produto produtoSalvo = produtoService.save(produto);

        assertNotNull(produtoSalvo); // Verifica que o produto foi salvo
        assertEquals("Produto Teste", produtoSalvo.getNome()); // Verifica o nome
	}
	
	@Test
    public void testSearchById() {
        // Cenário
        String response = "1";
        Produto produto = new Produto();
        produto.setId(1);
        produto.setNome("Produto Teste");

        when(produtoRepository.findById(1)).thenReturn(Optional.of(produto));

        // Ação
        List<Produto> resultado = produtoService.search(response);

        // Verificação
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Produto Teste", resultado.get(0).getNome());

        // Verifica se o método correto foi chamado
        verify(produtoRepository, times(1)).findById(1);
        verify(produtoRepository, never()).findByNomeContainingIgnoreCase(anyString());
    }

    @Test
    public void testSearchByNome() {
        // Cenário
        String response = "Produto Teste";
        Produto produto = new Produto();
        produto.setId(1);
        produto.setNome(response);

        when(produtoRepository.findByNomeContainingIgnoreCase(response)).thenReturn(List.of(produto));

        // Ação
        List<Produto> resultado = produtoService.search(response);

        // Verificação
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Produto Teste", resultado.get(0).getNome());

        // Verifica se o método correto foi chamado
        verify(produtoRepository, times(1)).findByNomeContainingIgnoreCase(response);
        verify(produtoRepository, never()).findById(anyInt());
    }
}
