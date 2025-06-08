package com.github.thiagoleitecarvalho.jwt.cover;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe para mapear os dados necessário para a geração do token.
 * @author Thiago Leite e Carvalho
 */
@Getter
@Setter
public class Autenticacao {

    /**
     * Cliente de geração de token.
     */
    private String cliente;

    /**
     * Senha de geração de token.
     */
    private String senha;

}
