package com.assessement.repository;

import com.assessement.entity.Pets;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PetsRepository extends MongoRepository<Pets, String> {
    Optional<Pets> findById(String id);
}