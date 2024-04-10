package com.logagg.springboot.handler;

import com.logagg.springboot.repository.LogEntry;
import com.logagg.springboot.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class LogEntryController {

    @Autowired
    private LogRepository logRepository;

    @PostMapping("/log")
    public void log(@RequestBody LogEntry logEntry){
        System.out.println(logEntry);
        logRepository.save(logEntry);
    }

    @GetMapping("/log")
    public @ResponseBody List<LogEntry> log() {
        return StreamSupport.stream(logRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
