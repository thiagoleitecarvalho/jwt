package com.github.thiagoleitecarvalho.jwt.controller.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.thiagoleitecarvalho.jwt.cover.Autenticacao;
import com.github.thiagoleitecarvalho.jwt.cover.JwtToken;
import com.github.thiagoleitecarvalho.jwt.exception.AutenticacaoException;
import com.github.thiagoleitecarvalho.jwt.service.AutenticacaoService;

/**
 * API Rest geração de token.
 * @author Thiago Leite e Carvalho
 */
@RestController
@CrossOrigin
public class AutenticacaoController {

    /**
     * Logs.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AutenticacaoController.class.getName());

    /** {@link AutenticacaoService}. */
    private final AutenticacaoService autenticacaoService;

    /**
     * Cosntrutor.
     * @param autenticacaoService Classe de gerenciamento da autenticação.
     */
    public AutenticacaoController(AutenticacaoService autenticacaoService) {
        this.autenticacaoService = autenticacaoService;
    }

    /**
     * Gera o token de autenticação para um cliente, qual deseja consumir serviços de uma API.
     * @param autenticacao Dados para a autenticação
     * @return Token de acesso
     * @throws AutenticacaoException {@link AutenticacaoException}
     */
    @PostMapping(path = "/auth", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JwtToken> obterToken(@ModelAttribute Autenticacao autenticacao) throws AutenticacaoException {

        LOGGER.info("Iniciando autenticação");

        var token = this.autenticacaoService.autenticar(autenticacao);

        LOGGER.info("Autenticação realizada com sucesso");
        return ResponseEntity.ok().body(token);
    }

}
