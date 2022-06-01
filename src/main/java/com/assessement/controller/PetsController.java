package com.assessement.controller;

import com.assessement.entity.Pets;
import com.assessement.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetsController {
    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pets> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pets> getPetById(@PathVariable("id") String id) {
        Optional<Pets> petData = petService.getPetById(id);
        if (petData.isPresent()) {
            return new ResponseEntity<>(petData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public void modifyPetById(@PathVariable("id") String id, @Valid
    @RequestBody Pets pets) {
        pets.setId(id);
        petService.save(pets);
    }

    @PostMapping
    public Pets createPet(@Valid @RequestBody Pets pets) {
        petService.save(pets);
        return pets;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePet(@PathVariable String id) {
        try {
            petService.deletePet(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Fail to delete!", HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>("Pet has been deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllPets() {
        try {
            petService.deleteAllPets();
        } catch (Exception e) {
            return new ResponseEntity<>("Fail to delete!", HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>("All Pets has been deleted!", HttpStatus.OK);
    }
}
