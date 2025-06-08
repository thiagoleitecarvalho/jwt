package com.github.thiagoleitecarvalho.jwt.controller.main;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.thiagoleitecarvalho.jwt.cover.Resposta;

/**
 * API Rest de exemplo.
 * @author Thiago Leite e Carvalho
 */
@RestController
@CrossOrigin
public class MainController {

    /**
     * Recurso protegido pelo token JWT.
     * @return Resposta genérica.
     */
    @GetMapping(path = "/fazerAlgo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resposta> fazerAlgo() {

        var resposta = new Resposta("Acessou recurso, pois foi fornecido um token válido.");
        return ResponseEntity.ok().body(resposta);
    }

}
