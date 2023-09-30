package com.gvendas.gestaovendas.controller;

import com.gvendas.gestaovendas.model.Categoria;
import com.gvendas.gestaovendas.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@AllArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        return ResponseEntity.ok().body(categoriaService.findAll());
    }

    @GetMapping("/{idCategoria}")
    public ResponseEntity<Categoria> findById(@PathVariable(value = "idCategoria") Long idCategoria) {
        return ResponseEntity.ok().body(categoriaService.findById(idCategoria));
    }

}
