package com.gvendas.gestaovendas.service;

import com.gvendas.gestaovendas.exceptions.DadoNaoEncontradoException;
import com.gvendas.gestaovendas.model.Categoria;
import com.gvendas.gestaovendas.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long idCategoria) {
        return categoriaRepository.findById(idCategoria).orElseThrow(() -> new DadoNaoEncontradoException("Categoria que representa o id " + idCategoria + " não encontrado."));
    }
}
