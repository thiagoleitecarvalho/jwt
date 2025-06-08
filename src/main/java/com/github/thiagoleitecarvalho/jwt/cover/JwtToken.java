package com.github.thiagoleitecarvalho.jwt.cover;

import lombok.Getter;

/**
 * Classe que represetna um token JWT de autenticação.
 * @author Thiago Leite e Carvalho
 */
@Getter
public class JwtToken {

    /**
     * Valor do token JWT.
     */
    private final String token;

    /**
     * Construtor.
     * @param token Valor do token de acesso.
     */
    public JwtToken(String token) {
        this.token = token;
    }

}
