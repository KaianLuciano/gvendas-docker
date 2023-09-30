package com.gvendas.gestaovendas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categoria")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;
    @Column(name = "nome")
    private String nome;

    public Categoria(Categoria categoriaOriginal, Categoria categoriaAtualizada) {
        this.codigo = categoriaOriginal.getCodigo();
        this.nome = categoriaAtualizada.getNome() != null ? categoriaAtualizada.getNome() : categoriaOriginal.getNome();
    }
}
