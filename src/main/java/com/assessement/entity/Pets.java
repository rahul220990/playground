package com.assessement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pets {
    @Id
    public String id;
    public String name;
    public String species;
    public String breed;

    // Constructors
    public Pets() {
    }

    public Pets(String id, String name, String species, String breed) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.breed = breed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
