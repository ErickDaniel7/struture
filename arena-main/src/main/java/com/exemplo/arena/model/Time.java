package com.exemplo.arena.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private boolean emPartida = false;

    @OneToOne
    private Jogador capitao;

    @ManyToMany
    private List<Jogador> membros;

    public double getMediaRank() {
        if (membros == null || membros.isEmpty()) return 0;
        return membros.stream().mapToInt(Jogador::getRankPontos).average().orElse(0);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public boolean isEmPartida() { return emPartida; }
    public void setEmPartida(boolean emPartida) { this.emPartida = emPartida; }
    public Jogador getCapitao() { return capitao; }
    public void setCapitao(Jogador capitao) { this.capitao = capitao; }
    public List<Jogador> getMembros() { return membros; }
    public void setMembros(List<Jogador> membros) { this.membros = membros; }
}