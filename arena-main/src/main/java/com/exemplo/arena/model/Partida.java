package com.exemplo.arena.model;

import jakarta.persistence.*;

@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Time timeA;

    @ManyToOne
    private Time timeB;

    @Enumerated(EnumType.STRING)
    private StatusPartida status;

    @ManyToOne
    private Time vencedor;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Time getTimeA() { return timeA; }
    public void setTimeA(Time timeA) { this.timeA = timeA; }
    public Time getTimeB() { return timeB; }
    public void setTimeB(Time timeB) { this.timeB = timeB; }
    public StatusPartida getStatus() { return status; }
    public void setStatus(StatusPartida status) { this.status = status; }
    public Time getVencedor() { return vencedor; }
    public void setVencedor(Time vencedor) { this.vencedor = vencedor; }
}