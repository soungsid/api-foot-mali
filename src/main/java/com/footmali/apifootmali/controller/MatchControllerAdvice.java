package com.footmali.apifootmali.controller;

import com.footmali.apifootmali.model.ApiProbleme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

@RestControllerAdvice
@Slf4j
public class MatchControllerAdvice {
    @ExceptionHandler({RestClientException.class})
    ResponseEntity<ApiProbleme> traiterRestClientException(Exception e) {
        ApiProbleme apiProbleme = new ApiProbleme();
        apiProbleme.setCodeHttp("500");
        apiProbleme.setMessage("Une erreur interne s'est produite dans l'application");
        log.error("Une erreur interne s'est produite dans l'application - Verifier le parametrage de l'url de l'api footdata : {}", e.getMessage());
        return ResponseEntity.status(500).body(apiProbleme);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    ResponseEntity<ApiProbleme> traiterIllegalArgumentException(IllegalArgumentException e) {
        ApiProbleme apiProbleme = new ApiProbleme();
        apiProbleme.setCodeHttp("500");
        apiProbleme.setMessage("Une erreur interne s'est produite dans l'application");
        log.error("Une erreur interne s'est produite dans l'application - L'url n'est pas valide : {}", e.getClass().getName());
        return ResponseEntity.status(401).body(apiProbleme);
    }

    @ExceptionHandler({Exception.class})
    ResponseEntity<ApiProbleme> traiterException(IllegalArgumentException e) {
        ApiProbleme apiProbleme = new ApiProbleme();
        apiProbleme.setCodeHttp("500");
        apiProbleme.setMessage("Une erreur interne s'est produite dans l'application");
        log.error("Une erreur interne s'est produite dans l'application : {}", e.getClass().getName());
        return ResponseEntity.status(500).body(apiProbleme);
    }
}


