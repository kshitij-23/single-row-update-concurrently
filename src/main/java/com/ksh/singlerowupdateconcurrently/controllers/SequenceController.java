package com.ksh.singlerowupdateconcurrently.controllers;

import com.ksh.singlerowupdateconcurrently.services.SequenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class SequenceController {

    @Autowired
    private SequenceService sequenceService;

    @GetMapping("/getNextSequenceNumber")
    public long getNextSequenceNumber() {
        Instant start = Instant.now();
        long generatedNumber = sequenceService.getNextSequenceNumber();
        Instant end = Instant.now();
        log.info(Duration.between(start, end).toMillis()+"ms,"+" Generated Number : "+generatedNumber);
        return generatedNumber;
    }

    @GetMapping("/getNextSequenceNumberList")
    public List<Long> getNextSequenceNumberList() {
        List<Long> longs = new ArrayList<>();
        Instant start = Instant.now();
        for(int i = 0; i < 3; i++) {
            long generatedNumber = sequenceService.getNextSequenceNumber();
            longs.add(generatedNumber);
        }
        Instant end = Instant.now();
        log.info(Duration.between(start, end).toMillis()+"ms,"+" Generated Number : "+longs);
        return longs;
    }
}
