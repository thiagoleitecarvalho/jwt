package com.github.thiagoleitecarvalho.jwt.filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.thiagoleitecarvalho.jwt.cover.Erro;
import com.github.thiagoleitecarvalho.jwt.util.JwtUtil;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Filtro para controle de autenticação.
 */
public class AutenticacaoFilter extends OncePerRequestFilter {

    /**
     * Logs.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AutenticacaoFilter.class.getName());

    /** {@inheritDoc}. */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        LOGGER.info("Entrou no AutenticacaoFilter");

        var url = request.getRequestURL().toString();
        if (!url.endsWith("/auth")) {

            var token = request.getHeader("Authorization");

            if (token == null || token.isEmpty()) {

                LOGGER.info("Token ausente");
                configurarResponseAutorizacaoNegada("Token ausente", response);
                return;
            } else {

                try {
                    JwtUtil.validarToken(token);
                } catch (JwtException e) {

                    LOGGER.info("Token expidado ou inválido");
                    configurarResponseAutorizacaoNegada("Token expidado ou inválido", response);
                    return;
                }

                LOGGER.info("Token ok");
            }

        }

        chain.doFilter(request, response);

    }

    /**
     * Configura o response para autorização negada(HTTP 401 - UNAUTHORIZED).
     * @param mensagem Mensagem customizada da causa da não autorização
     * @param response Response a ser configurado
     * @throws IOException Erro na configuração.
     */
    private void configurarResponseAutorizacaoNegada(String mensagem, HttpServletResponse response) throws IOException {

        response.setStatus(401);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        var erro = new Erro();
        erro.setMensagem(mensagem);
        var json = new ObjectMapper().writeValueAsString(erro);
        response.getWriter().write(json);
    }

}
