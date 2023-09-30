package com.gvendas.gestaovendas.service;

import com.gvendas.gestaovendas.exceptions.DadoNaoEncontradoException;
import com.gvendas.gestaovendas.model.Produto;
import com.gvendas.gestaovendas.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long idProduto) {
        return produtoRepository.findById(idProduto).orElseThrow(() -> new DadoNaoEncontradoException("Produto com o id " + idProduto + " não encontrado."));
    }
}
