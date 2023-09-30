package com.gvendas.gestaovendas.exceptions;

import lombok.Getter;

@Getter
public class DadoNaoEncontradoException extends RuntimeException{

    private String msg;

    public DadoNaoEncontradoException(String msg) {
        this.msg = msg;
    }
}
