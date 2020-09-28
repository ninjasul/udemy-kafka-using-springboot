package com.udemy.kafka.library.events.producer.domain;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class LibraryEvent {
    private Integer libraryEventId;
    private LibraryEventType libraryEventType;
    private Book book;

    @Builder
    public LibraryEvent(Integer libraryEventId, LibraryEventType libraryEventType, Book book) {
        this.libraryEventId = libraryEventId;
        this.libraryEventType = libraryEventType;
        this.book = book;
    }
}
