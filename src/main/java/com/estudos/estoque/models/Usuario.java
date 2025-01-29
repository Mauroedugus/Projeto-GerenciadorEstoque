package com.estudos.estoque.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(nullable = false, length = 50)
	private String nivel;
	
	@Column(nullable = false, length = 50)
	private String senha;

	
}
