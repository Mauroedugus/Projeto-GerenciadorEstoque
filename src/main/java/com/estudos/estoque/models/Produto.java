package com.estudos.estoque.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private double valor_custo;

    @Column(nullable = false)
    private double valor_venda;
    
    @Column(nullable = false)
    private int quantidade;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;


}
