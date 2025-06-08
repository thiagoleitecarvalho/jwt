package com.github.thiagoleitecarvalho.jwt.service;

import static org.springframework.util.ObjectUtils.isEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.github.thiagoleitecarvalho.jwt.cover.Autenticacao;
import com.github.thiagoleitecarvalho.jwt.cover.JwtToken;
import com.github.thiagoleitecarvalho.jwt.exception.AutenticacaoException;
import com.github.thiagoleitecarvalho.jwt.util.JwtUtil;

/**
 * Classe de negócio para validação do cliente que solicita o token e para a geração do token JWT.
 * @author Thiago Leite e Carvalho
 */
@Service
public class AutenticacaoService {

    /**
     * Logs.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AutenticacaoService.class.getName());

    /**
     * Chave secreta do cliente para geração do token.
     */
    private static final String SENHA = "Bl**[CO$<Do@";

    /**
     * Executa a autenticação de um cliente.
     * @param autenticacao Dados para autenticação
     * @return Token gerado, qual viabiliza a autenticação.
     * @throws AutenticacaoException Erro durante a autenticação.
     */
    public JwtToken autenticar(Autenticacao autenticacao) throws AutenticacaoException {

        autenticarCliente(autenticacao.getCliente(), autenticacao.getSenha());

        LOGGER.info("Gerando token.");
        var tokenValue = JwtUtil.gerarToken(autenticacao.getCliente());

        LOGGER.info("Token gerado com sucesso e sendo retornado.");
        return new JwtToken(tokenValue);
    }

    /**
     * Método para validar os dadso do cliente que está solicitando a geração de um token de acesso.
     * @param cliente Cliente solicitante do token
     * @param senha Senha do cliente solicitante do token
     * @throws AutenticacaoException {@link AutenticacaoException}
     */
    private void autenticarCliente(String cliente, String senha) throws AutenticacaoException {

        LOGGER.info("Autenticando o cliente {} com a senha {}", cliente, senha);

        if (isEmpty(cliente) || isEmpty(senha)) {

            LOGGER.info("Cliente ou senha vazios");

            throw new AutenticacaoException("Autenticação inválida. Cliente ou senha não fornecidos.",
                    HttpStatus.BAD_REQUEST);
        }

        if (!SENHA.equals(senha)) {

            throw new AutenticacaoException("Autenticação não permitida. Cliente ou senha inválidos.",
                    HttpStatus.UNAUTHORIZED);
        }

        LOGGER.info("Sucesso na autenticação. Cliente e senha válidos. Vai gerar token.");
    }

}
