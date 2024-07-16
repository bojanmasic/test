package com.example.test.service.impl;

import com.example.test.model.Trainer;
import com.example.test.repository.TrainerRepository;
import com.example.test.service.TrainerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerServiceImpl(final TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    @Transactional
    public Trainer saveTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    @Override
    @Transactional
    public Trainer updateTrainer(int id, String ime, String prezime, String licenca) {
        Trainer currentTrainer = trainerRepository.findById(id)
                .orElseThrow();
        compareAndUpdateTrainer(currentTrainer, ime, prezime, licenca);
        return currentTrainer;
    }

    private void compareAndUpdateTrainer(Trainer currentTrainer, String ime, String prezime, String licenca) {
        if (!currentTrainer.compare(ime, prezime, licenca)) {
            currentTrainer.setIme(
                    ime == null ? currentTrainer.getIme() : ime
            );
            currentTrainer.setPrezime(
                    prezime == null ? currentTrainer.getPrezime() : prezime
            );
            currentTrainer.setLicenca(
                    licenca == null ? currentTrainer.getLicenca() : licenca
            );
        }
    }
}
