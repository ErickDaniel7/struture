package com.exemplo.arena.controller;

import com.exemplo.arena.model.Jogador;
import com.exemplo.arena.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorRepository repo;

    @PostMapping
    public Jogador criar(@RequestBody Jogador j) { return repo.save(j); }

    @GetMapping
    public List<Jogador> listar() { return repo.findAll(); }
}