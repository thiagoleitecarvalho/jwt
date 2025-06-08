package com.github.thiagoleitecarvalho.jwt.cover;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe cover para encapsular os erros de negócio e fornecer uma resposta amigável ao cliente da API.
 * @author Thiago Leite e Carvalho
 */
@Getter
@Setter
public class Erro {

    /**
     * Mensagem de erro retornada, devido a alguma validação de negócio.
     */
    private String mensagem;

}
