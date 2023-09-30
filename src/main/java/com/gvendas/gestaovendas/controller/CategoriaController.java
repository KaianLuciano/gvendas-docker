package com.gvendas.gestaovendas.controller;

import com.gvendas.gestaovendas.model.Categoria;
import com.gvendas.gestaovendas.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@AllArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Operation(summary = "Lista todas categorias")
    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        return ResponseEntity.ok().body(categoriaService.findAll());
    }

    @Operation(summary = "Busca a categoria que representa o ID fornecido")
    @GetMapping("/{idCategoria}")
    public ResponseEntity<Categoria> findById(@PathVariable(value = "idCategoria") Long idCategoria) {
        return ResponseEntity.ok().body(categoriaService.findById(idCategoria));
    }

    @Operation(summary = "Salva a categoria passada como parâmetro.")
    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }

}
