package com.gvendas.gestaovendas.controller;

import com.gvendas.gestaovendas.model.Produto;
import com.gvendas.gestaovendas.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok().body(produtoService.findAll());
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<Produto> findById(@PathVariable(value = "idProduto") Long idProduto) {
        return ResponseEntity.ok().body(produtoService.findById(idProduto));
    }
}
