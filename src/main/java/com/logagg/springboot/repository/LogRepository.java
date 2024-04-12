package com.logagg.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends CrudRepository<LogEntry, Long> {
    @Override
    List<LogEntry> findAll();

}
