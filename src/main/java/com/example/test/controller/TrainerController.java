package com.example.test.controller;

import com.example.test.model.Trainer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/trainers")
public interface TrainerController {

    @GetMapping
    List<Trainer> getTrainers();

    @PostMapping
    Trainer createTrainer(@RequestBody Trainer trainer);

    @PutMapping("/{id}")
    Trainer updateTrainer(
            @PathVariable int id,
            @RequestParam String ime,
            @RequestParam String prezime,
            @RequestParam String licenca);
}
