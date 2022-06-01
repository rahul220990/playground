package com.assessement.service;

import com.assessement.entity.Pets;
import com.assessement.repository.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetsRepository repository;

    public List<Pets> getAllPets() {
        return repository.findAll();
    }

    public Optional<Pets> getPetById(String id) {
        return repository.findById(id);
    }

    public void save(Pets pets) {
        repository.save(pets);
    }

    public Pets createPet(Pets pets) {
        repository.save(pets);
        return pets;
    }

    public void deletePet(String id) {
        repository.deleteById(id);
    }

    public void deleteAllPets() {
            repository.deleteAll();
    }

}
