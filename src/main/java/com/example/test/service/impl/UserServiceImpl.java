package com.example.test.service.impl;

import com.example.test.model.User;
import com.example.test.repository.UserRepository;
import com.example.test.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(int id, String ime, String prezime, String email, String telefonskiBroj) {
        User currentUser = userRepository.findById(id)
                .orElseThrow();
        compareAndUpdateUser(currentUser, ime, prezime, email, telefonskiBroj);
        return currentUser;
    }

    private void compareAndUpdateUser(User currentUser, String ime, String prezime, String email, String telefonskiBroj) {
        if (!currentUser.compare(ime, prezime, email, telefonskiBroj)) {
            currentUser.setIme(
                    ime == null ? currentUser.getIme() : ime
            );
            currentUser.setPrezime(
                    prezime == null ? currentUser.getPrezime() : prezime
            );
            currentUser.setEmail(
                    email == null ? currentUser.getEmail() : email
            );
            currentUser.setTelefonski_broj(
                    telefonskiBroj == null ? currentUser.getTelefonski_broj() : telefonskiBroj
            );
        }
    }

}
