package com.footmali.apifootmali.controller;

import com.footmali.apifootmali.model.Match;
import com.footmali.apifootmali.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;


    @GetMapping("/match-jour")
    String getListeMatchDuJour() {

        return matchService.getListeMatchDuJour();
    }

    @GetMapping("/match")
    List<Match> getMatch() {
        Match match = new Match();
        match.setTeamAway("Liverpool");
        match.setTeamHome("Chelsea");
        return List.of(match);
    }


    @GetMapping("/match/{id}")
    List<Match> getMatchById(@PathVariable Integer id) {
        Match match = new Match();
        match.setId(id);
        match.setTeamAway("Liverpool");
        match.setTeamHome("Chelsea");
        return List.of(match);
    }

    @PostMapping("/match")
    Match creerMatch(@RequestBody Match match) {
        System.out.println(match);
        return match;
    }

}

