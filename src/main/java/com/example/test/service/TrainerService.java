package com.example.test.service;

import com.example.test.model.Trainer;

import java.util.List;

public interface TrainerService {

    List<Trainer> getAllTrainers();

    Trainer saveTrainer(Trainer trainer);

    Trainer updateTrainer(int id, String ime, String prezime, String licenca);
}
