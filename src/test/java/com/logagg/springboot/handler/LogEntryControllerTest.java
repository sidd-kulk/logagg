package com.logagg.springboot.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logagg.springboot.repository.LogEntry;
import com.logagg.springboot.repository.LogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@SpringBootTest
@AutoConfigureMockMvc
public class LogEntryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LogRepository logRepository;

    @InjectMocks
    private LogEntryController logEntryController;

    @Test
    public void testLogEndpoint() throws Exception {
        LogEntry logEntry = new LogEntry("Test log entry");
        // Set up your logEntry object

        mockMvc.perform(post("/log")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(logEntry)))
                .andExpect(status().isOk());

        verify(logRepository, times(1)).save(logEntry);
    }

    @Test
    public void testGetAllLogsEndpoint() throws Exception {
        List<LogEntry> logEntries = List.of(new LogEntry("Test log entry 1"), new LogEntry("Test log entry 2"));

        when(logRepository.findAll()).thenReturn(logEntries);

        mockMvc.perform(get("/log")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(logEntries)));
    }

    // Utility method to convert object to JSON string
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
