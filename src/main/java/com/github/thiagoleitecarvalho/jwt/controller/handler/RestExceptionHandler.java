package com.github.thiagoleitecarvalho.jwt.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.github.thiagoleitecarvalho.jwt.cover.Erro;
import com.github.thiagoleitecarvalho.jwt.exception.AutenticacaoException;

/**
 * Controller auxiliar para capturar erros de négocio e fornecer uma resposta amigável para os clientes das APIs.
 * @author Thiago Leite e Carvalho
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Trata erros de acesso a API de geração de token.
     * @param erro Exception de dadso de cliente inválidos
     * @return Entidade representando um erro para ser retornado ao cliente da API.
     */
    @ExceptionHandler(AutenticacaoException.class)
    public ResponseEntity<Erro> tratarAutenticacaoException(AutenticacaoException erro) {

        Erro erroCover = new Erro();
        erroCover.setMensagem(erro.getMessage());
        return new ResponseEntity<>(erroCover, erro.getStatus());
    }

}
