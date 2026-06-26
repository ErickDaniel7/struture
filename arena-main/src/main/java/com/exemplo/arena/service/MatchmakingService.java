package com.exemplo.arena.service;

import com.exemplo.arena.model.*;
import com.exemplo.arena.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MatchmakingService {

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

    @Transactional
    public Partida criarPartidaMatchmaking(Long idTimeA, Long idTimeB) {
        Time timeA = timeRepository.findById(idTimeA)
                .orElseThrow(() -> new IllegalArgumentException("Time A não encontrado."));
        Time timeB = timeRepository.findById(idTimeB)
                .orElseThrow(() -> new IllegalArgumentException("Time B não encontrado."));

        if (timeA.isEmPartida() || timeB.isEmPartida()) {
            throw new IllegalStateException("Um ou ambos os times já estão em uma partida ativa.");
        }

        double diferenca = Math.abs(timeA.getMediaRank() - timeB.getMediaRank());
        if (diferenca > 500) {
            throw new IllegalArgumentException("Matchmaking Recusado: Diferença de nível muito alta (" + diferenca + " pontos).");
        }

        timeA.setEmPartida(true);
        timeB.setEmPartida(true);
        timeRepository.save(timeA);
        timeRepository.save(timeB);

        Partida partida = new Partida();
        partida.setTimeA(timeA);
        partida.setTimeB(timeB);
        partida.setStatus(StatusPartida.EM_ANDAMENTO);

        return partidaRepository.save(partida);
    }

    @Transactional
    public Partida finalizarPartida(Long idPartida, Long idTimeVencedor) {
        Partida partida = partidaRepository.findById(idPartida)
                .orElseThrow(() -> new IllegalArgumentException("Partida não encontrada."));

        if (partida.getStatus() == StatusPartida.FINALIZADA) {
            throw new IllegalStateException("Esta partida já foi finalizada.");
        }

        Time vencedor = timeRepository.findById(idTimeVencedor)
                .orElseThrow(() -> new IllegalArgumentException("Time vencedor inválido."));

        Time perdedor = (partida.getTimeA().getId().equals(idTimeVencedor)) ? partida.getTimeB() : partida.getTimeA();

        for (Jogador j : vencedor.getMembros()) {
            j.setRankPontos(j.getRankPontos() + 25);
            jogadorRepository.save(j);
        }

        for (Jogador j : perdedor.getMembros()) {
            int novoRank = Math.max(0, j.getRankPontos() - 25);
            j.setRankPontos(novoRank);
            jogadorRepository.save(j);
        }

        partida.getTimeA().setEmPartida(false);
        partida.getTimeB().setEmPartida(false);
        timeRepository.save(partida.getTimeA());
        timeRepository.save(partida.getTimeB());

        partida.setVencedor(vencedor);
        partida.setStatus(StatusPartida.FINALIZADA);

        return partidaRepository.save(partida);
    }
}