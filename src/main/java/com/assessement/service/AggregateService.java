package com.assessement.service;

import com.assessement.repository.AggregationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AggregateService {

    @Autowired
    AggregationRepository aggregationRepository;

    public List getCities()
    {
        return aggregationRepository.getCities();
    }
}
