package com.ksh.singlerowupdateconcurrently.controllers;

import com.ksh.singlerowupdateconcurrently.services.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;

@RestController
public class SequenceController {

    @Autowired
    private SequenceService sequenceService;

    @GetMapping("/getNextSequenceNumber")
    public long getNextSequenceNumber() {
        Instant start = Instant.now();
        long generatedNumber = sequenceService.getNextSequenceNumber();
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis()+"ms");
        return generatedNumber;
    }

}
