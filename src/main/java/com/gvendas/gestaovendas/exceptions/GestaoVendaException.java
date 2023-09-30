package com.gvendas.gestaovendas.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GestaoVendaException  extends ResponseEntityExceptionHandler {

    public static final String VALIDATION_NOT_BLANK = "NotBlank";
    public static final String VALIDATION_NOT_LENGTH = "Length";

    @ExceptionHandler(DadoNaoEncontradoException.class)
    public ResponseEntity<String> dadosNaoEncontrado(DadoNaoEncontradoException dadoNaoEncontradoException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dadoNaoEncontradoException.getMsg());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<Erro> erros = gerenciarListaDeErros(ex.getBindingResult());
        return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
    }

    private List<Erro> gerenciarListaDeErros(BindingResult bindingResult) {
        List<Erro> erros = new ArrayList<>();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            String msgUsuario = tratarMensagemDeErroParaUsuario(fieldError);
            String msgDesenvolvedor = fieldError.toString();
            erros.add(new Erro(msgUsuario, msgDesenvolvedor));
        });

        return erros;
    }

    private String tratarMensagemDeErroParaUsuario(FieldError fieldError) {
        if(fieldError.getCode().equals(VALIDATION_NOT_BLANK)) {
            return fieldError.getDefaultMessage().concat(" é obrigatorio");
        }
        if(fieldError.getCode().equals(VALIDATION_NOT_LENGTH)) {
            return fieldError.getDefaultMessage().concat(String.format(" deve ter entre %s e %s caracteres.", fieldError.getArguments()[2], fieldError.getArguments()[1]));
        }
        return fieldError.toString();
    }
}