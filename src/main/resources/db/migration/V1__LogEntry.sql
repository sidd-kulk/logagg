CREATE TABLE IF NOT EXISTS log_entry
(
    id    SERIAL,
    message TEXT,
    timestamp TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP
);