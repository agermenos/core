package com.itn.mapper.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/version")
    public ResponseEntity<String> version()
    {

        return new ResponseEntity<>("0.0.1", HttpStatus.OK);
    }

    @GetMapping("/alive")
    public ResponseEntity<String> alive()
    {
        return new ResponseEntity<>("GREEN", HttpStatus.OK);
    }
}
