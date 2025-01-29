package com.estudos.estoque.models;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "entrada_produto")
public class EntradaProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_produto", nullable = false)
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
	
	@Column(nullable = false)
	private int quantidade;
	
	@Column(nullable = false)
	private double valor;
	
	@Column(nullable = false)
	private LocalDate data;
	
	@Column(columnDefinition = "TEXT")
	private String observacao;
}
