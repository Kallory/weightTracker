package com.weightTracker.weightTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "127.0.0.1:8080")
@RestController
@RequestMapping("/main")
public class WeightEntryRequestController {
    @Autowired
    WeightRepository weightRepository;

    public WeightEntryRequestController(WeightRepository weightRepository) {
        this.weightRepository = weightRepository;
    }
    @PostMapping("/entry")
    public ResponseEntity<String> newWeightEntry(@RequestBody WeightRequest weightRequest) {

        return new ResponseEntity<>("Hey", HttpStatus.OK);
    }
}
