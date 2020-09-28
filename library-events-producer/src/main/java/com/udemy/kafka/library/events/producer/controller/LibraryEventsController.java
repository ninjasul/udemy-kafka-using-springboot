package com.udemy.kafka.library.events.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.udemy.kafka.library.events.producer.domain.LibraryEvent;
import com.udemy.kafka.library.events.producer.producer.LibraryEventProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@Slf4j
public class LibraryEventsController {
    @Autowired
    private LibraryEventProducer libraryEventProducer;

    @PostMapping("/v1/libraryevent")
    public ResponseEntity<LibraryEvent> postLibraryEvent(
        @RequestBody LibraryEvent libraryEvent
    ) throws JsonProcessingException, ExecutionException, InterruptedException {
        log.info("Before sendLibraryEvent()");
        //libraryEventProducer.sendLibraryEvent(libraryEvent);
        SendResult<Integer, String> sendResult = libraryEventProducer.sendLibraryEventSynchronous(libraryEvent);
        log.info("SendResult is {}", sendResult.toString());
        log.info("After sendLibraryEvent()");

        return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
    }
}
