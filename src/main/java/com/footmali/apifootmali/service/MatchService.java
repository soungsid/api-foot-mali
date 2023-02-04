package com.footmali.apifootmali.service;

import com.footmali.apifootmali.model.Match;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class MatchService {

    @Value("${api.url}")
    String footballApiUrl;
    @Value("${FOOTBALL_DATA_API_TOKEN}")
    String apiToken;


    public String getListeMatchDuJour() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Auth-Token", apiToken);
        HttpEntity<Void> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = null;

        response = restTemplate.exchange(footballApiUrl, HttpMethod.GET, httpEntity, String.class);

        log.error("Attention une erreur s'est produite lors de l'appel de l'api footdata.org");

        return response.getBody();
    }

    public Match getMatchById(Integer id) {

        Match match = new Match();
        match.setId(id);
        match.setTeamAway("Liverpool");
        match.setTeamHome("Chelsea");
        return match;

    }

}
