package com.github.thiagoleitecarvalho.jwt.cover;

import lombok.Getter;

/**
 * Classe que represetna uma resposta qualquer.
 * @author Thiago Leite e Carvalho
 */
@Getter
public class Resposta {

    /**
     * Texto aleatório.
     */
    private final String mensagem;

    /**
     * Construtor.
     * @param mensagem Texto.
     */
    public Resposta(String mensagem) {
        this.mensagem = mensagem;
    }

}
