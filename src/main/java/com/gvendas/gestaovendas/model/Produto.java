package com.gvendas.gestaovendas.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produto")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "preco_custo")
    private Double precoCusto;
    @Column(name = "preco_venda")
    private Double precoVenda;
    @Column(name = "observacao")
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
    private Categoria categoria;

}
