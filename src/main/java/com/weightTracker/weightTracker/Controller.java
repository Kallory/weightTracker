package com.weightTracker.weightTracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/main")
public class Controller {
    public ResponseEntity<String> start() {
        return new ResponseEntity<>("Hi", HttpStatus.OK);
    }
}
