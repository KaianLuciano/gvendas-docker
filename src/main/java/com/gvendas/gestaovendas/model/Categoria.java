package com.gvendas.gestaovendas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;
    @Column(name = "nome")
    @NotBlank(message = "Nome")
    @Length(min = 2, max = 50, message = "Nome")
    private String nome;

    public Categoria(Categoria categoriaOriginal, Categoria categoriaAtualizada) {
        this.codigo = categoriaOriginal.getCodigo();
        this.nome = categoriaAtualizada.getNome() != null ? categoriaAtualizada.getNome() : categoriaOriginal.getNome();
    }
}
