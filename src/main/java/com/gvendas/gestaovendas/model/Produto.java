package com.gvendas.gestaovendas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produto")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
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
