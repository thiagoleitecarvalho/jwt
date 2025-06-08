package com.github.thiagoleitecarvalho.jwt.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * Exceção auxilizar para erros de autenticação(authentication).
 * @author Thiago Leite e Carvalho
 */
@Getter
public class AutenticacaoException extends Exception {

    /**
     * Serial id.
     */
    private static final long serialVersionUID = -9141634705422825685L;

    /**
     * HTTP Status code compatível com o erro de autenticação.
     */
    private final HttpStatus status;

    /**
     * Cosntrutor.
     * @param mensagem Mensagem de erro de autenticação
     * @param status HttpStatus do erro
     */
    public AutenticacaoException(String mensagem, HttpStatus status) {

        super(mensagem);
        this.status = status;
    }

}
