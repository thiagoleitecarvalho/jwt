package com.github.thiagoleitecarvalho.jwt.util;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Classe utiliária para geração e validação do JWT token.
 */
public final class JwtUtil {

    /**
     * Chave secreta para a geração do token.
     */
    private static final String SECRET = "minha-chave-super-secreta-para-jwt-que-tem-mais-de-32-caracteres";

    /**
     * Key gerada para assinar o token. Usa o SECRET para geração.
     */
    private static Key signingKey;

    /**
     * Bloco static para inicialização dos dados.
     */
    static {

        byte[] keyBytes = SECRET.getBytes();
        signingKey = new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
    }

    /**
     * Gera um token JWT para um cliente solicitante.
     * @param cliente Nome do cliente que solicita a geração do token
     * @return String representando o token.
     */
    public static String gerarToken(String cliente) {

        Date dataCriacaoToken = new Date();
        Date dataExpiracaoToken = new Date(dataCriacaoToken.getTime() + 60000); // dataCriacaoToken + 60s

        return Jwts.builder()
                .setSubject(cliente)
                .setIssuer("liveJWT")
                .setIssuedAt(dataCriacaoToken)
                .setExpiration(dataExpiracaoToken)
                .signWith(SignatureAlgorithm.HS256, signingKey)
                .compact();
    }

    /**
     * Valida um token JWT.
     * @param token Token a ser validade
     * @return Claims contidos no token
     */
    public static Claims validarToken(String token) {
        return Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token.substring(7))
                .getBody();
    }
}
