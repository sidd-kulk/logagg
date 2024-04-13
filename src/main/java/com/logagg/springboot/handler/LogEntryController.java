package com.logagg.springboot.handler;

import com.logagg.springboot.repository.LogEntry;
import com.logagg.springboot.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LogEntryController {

    @Autowired
    private LogRepository logRepository;

    @PostMapping("/log")
    public void log(@RequestBody LogEntry logEntry) {
        logRepository.save(logEntry);
    }

    @GetMapping("/log")
    public List<LogEntry> log(@RequestParam(required = false) Integer count) {
        return (count == null || count <= 0) ? logRepository.findAll() : logRepository.findLimited(count);
    }
}
