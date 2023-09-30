package com.gvendas.gestaovendas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionGeral {

    @ExceptionHandler(DadoNaoEncontradoException.class)
    public ResponseEntity<String> dadosNaoEncontrado(DadoNaoEncontradoException dadoNaoEncontradoException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dadoNaoEncontradoException.getMsg());
    }
}
