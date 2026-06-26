package com.exemplo.arena.controller;

import com.exemplo.arena.model.Time;
import com.exemplo.arena.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeService service;

    @PostMapping
    public ResponseEntity<?> criarTime(@RequestBody Time time) {
        try {
            Time salvo = service.salvarTime(time);
            return ResponseEntity.ok(salvo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Time> listar() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public Time buscar(@PathVariable Long id) { return service.buscarPorId(id); }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { service.deletarTime(id); }
}