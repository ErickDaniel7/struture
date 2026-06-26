package com.exemplo.arena.service;

import com.exemplo.arena.model.Time;
import com.exemplo.arena.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public Time salvarTime(Time time) {
        if (time.getMembros() == null || time.getMembros().size() != 5) {
            throw new IllegalArgumentException("Regra de Negócio: O time precisa ter exatamente 5 jogadores.");
        }
        if (time.getCapitao() == null || time.getCapitao().getRankPontos() < 2500) {
            throw new IllegalArgumentException("Regra de Negócio: O capitão precisa ter no mínimo 2500 pontos de Rank.");
        }
        return timeRepository.save(time);
    }

    public List<Time> listarTodos() { return timeRepository.findAll(); }
    public Time buscarPorId(Long id) { return timeRepository.findById(id).orElse(null); }
    public void deletarTime(Long id) { timeRepository.deleteById(id); }
}