package com.gvendas.gestaovendas.controller;

import com.gvendas.gestaovendas.model.Categoria;
import com.gvendas.gestaovendas.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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
        return ResponseEntity.ok(categoriaService.findAll());
    }

    @Operation(summary = "Busca a categoria que representa o ID fornecido")
    @GetMapping("/{idCategoria}")
    public ResponseEntity<Categoria> findById(@PathVariable(value = "idCategoria") Long idCategoria) {
        return ResponseEntity.ok(categoriaService.findById(idCategoria));
    }

    @Operation(summary = "Salva a categoria passada como parâmetro.")
    @PostMapping
    public ResponseEntity<Categoria> save(@Valid @RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }
    @Operation(summary = "Atualiza a categoria que representa o código fornecido.")
    @PutMapping("/{codigo}")
    public ResponseEntity<Categoria> update(@Valid @RequestBody Categoria categoriaAtualizada) {
        return ResponseEntity.ok(categoriaService.update(categoriaAtualizada));
    }

    @Operation(summary = "Deleta a categoria que representa o código fornecido")
    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(@PathVariable(value = "codigo") Long codigo) {
        categoriaService.delete(codigo);
    }

}
