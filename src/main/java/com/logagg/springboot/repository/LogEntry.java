package com.logagg.springboot.repository;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.sql.Timestamp;
import java.util.Objects;

public final class LogEntry {
    @Id
    @JsonProperty
    private Integer id;

    @JsonProperty
    private String message;

    @JsonProperty
    @ReadOnlyProperty
    private Timestamp timestamp;

    @JsonCreator
    public LogEntry(@JsonProperty("message") String message) {
        this.message = message;
    }

    public Integer id() {
        return id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (LogEntry) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message);
    }

    @Override
    public String toString() {
        return "LogEntry[" +
                "id=" + id + ", " +
                "message=" + message + ']';
    }

}
