package com.udemy.kafka.library.events.producer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udemy.kafka.library.events.producer.domain.Book;
import com.udemy.kafka.library.events.producer.domain.LibraryEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LibraryEventsControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("/v1/libraryevent 테스트")
    void v1_libraryevent() throws Exception {
        LibraryEvent libraryEvent = LibraryEvent.builder()
            .libraryEventId(null)
            .book(buildBook())
            .build();

        mockMvc.perform(
            MockMvcRequestBuilders.post("/v1/libraryevent")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(libraryEvent)
            )
        )
        .andExpect(status().isCreated())
        .andExpect(result -> result.getResponse().getContentAsString().equals(libraryEvent));
    }

    private Book buildBook() {
        return Book.builder()
            .bookId(456)
            .bookName("Kafka Using SpringBoot")
            .bookAuthor("Dilip")
            .build();
    }
}