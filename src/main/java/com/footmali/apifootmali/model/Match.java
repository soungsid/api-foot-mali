package com.footmali.apifootmali.model;


import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Match {
    Integer id;
    String teamHome;
    String teamAway;

}
