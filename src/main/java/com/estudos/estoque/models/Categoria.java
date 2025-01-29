package com.estudos.estoque.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categoria")
public class Categoria { 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(columnDefinition = "TEXT")
	private String descricao;

	
}

