package com.logagg.springboot.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends CrudRepository<LogEntry, Long> {

    @Override
    List<LogEntry> findAll();

    @Query(value = "SELECT * FROM log_entry ORDER BY id DESC LIMIT :count")
    List<LogEntry> findLimited(@Param("count") int count);

}
