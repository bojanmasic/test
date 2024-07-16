package com.example.test.controller.impl;

import com.example.test.controller.TrainerController;
import com.example.test.model.Trainer;
import com.example.test.service.TrainerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainers")
public class TrainerControllerImpl implements TrainerController {

    private final TrainerService trainerService;

    public TrainerControllerImpl(final TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @Override
    @GetMapping
    public List<Trainer> getTrainers() {
        return trainerService.getAllTrainers();
    }

    @Override
    @PostMapping
    public Trainer createTrainer(@RequestBody Trainer trainer) {
        return trainerService.saveTrainer(trainer);
    }

    @Override
    @PutMapping("/{id}")
    public Trainer updateTrainer(
            @PathVariable int id,
            @RequestParam String ime,
            @RequestParam String prezime,
            @RequestParam String licenca) {
        return trainerService.updateTrainer(id, ime, prezime, licenca);
    }
}
