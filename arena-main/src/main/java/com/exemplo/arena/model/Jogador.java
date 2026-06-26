package com.exemplo.arena.model;

import jakarta.persistence.*;

@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private int rankPontos;

    public Jogador() {}

    public Jogador(String nickname, int rankPontos) {
        this.nickname = nickname;
        this.rankPontos = rankPontos;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public int getRankPontos() { return rankPontos; }
    public void setRankPontos(int rankPontos) { this.rankPontos = rankPontos; }
}