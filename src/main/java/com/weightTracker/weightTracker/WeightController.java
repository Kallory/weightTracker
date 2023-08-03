package com.weightTracker.weightTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "127.0.0.1:8080")
@RestController
@RequestMapping("/main")
public class WeightController {

    @Autowired
    private WeightRepository weightRepository;

    @GetMapping("/weights")
    public List<Weight> getAllWeights() {
        return weightRepository.findAll();
    }

    @GetMapping("/firstEntry")
    public ResponseEntity<Weight> getFirstWeight() {
        return weightRepository.findTopByOrderByLocalDateAsc()
                .map(weight -> new ResponseEntity<>(weight, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}