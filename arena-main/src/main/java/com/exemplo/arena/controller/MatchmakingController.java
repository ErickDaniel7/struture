package com.exemplo.arena.controller;

import com.exemplo.arena.model.Partida;
import com.exemplo.arena.service.MatchmakingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matchmaking")
public class MatchmakingController {

    @Autowired
    private MatchmakingService service;

    @PostMapping("/buscar-partida")
    public ResponseEntity<?> buscarPartida(@RequestParam Long idTimeA, @RequestParam Long idTimeB) {
        try {
            Partida partida = service.criarPartidaMatchmaking(idTimeA, idTimeB);
            return ResponseEntity.ok(partida);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/finalizar")
    public ResponseEntity<?> finalizarPartida(@RequestParam Long idPartida, @RequestParam Long idVencedor) {
        try {
            Partida partida = service.finalizarPartida(idPartida, idVencedor);
            return ResponseEntity.ok(partida);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}