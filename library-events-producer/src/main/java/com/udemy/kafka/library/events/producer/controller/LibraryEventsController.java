package com.udemy.kafka.library.events.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.udemy.kafka.library.events.producer.domain.LibraryEvent;
import com.udemy.kafka.library.events.producer.domain.LibraryEventType;
import com.udemy.kafka.library.events.producer.producer.LibraryEventProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LibraryEventsController {
    @Autowired
    private LibraryEventProducer libraryEventProducer;

    @PostMapping("/v1/libraryevent")
    public ResponseEntity<LibraryEvent> postLibraryEvent(
        @RequestBody LibraryEvent libraryEvent
    ) throws JsonProcessingException {
        libraryEvent.setLibraryEventType(LibraryEventType.NEW);
        libraryEventProducer.sendLibraryEvent_Approach2(libraryEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
    }
}
