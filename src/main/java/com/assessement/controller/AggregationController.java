package com.assessement.controller;

import com.assessement.service.AggregateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aggregate")
public class AggregationController {

    @Autowired
    AggregateService aggregateService;

    @GetMapping
    public List getCities()
    {
        return aggregateService.getCities();
    }
}
