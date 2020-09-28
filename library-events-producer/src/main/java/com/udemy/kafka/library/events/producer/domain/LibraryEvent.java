package com.udemy.kafka.library.events.producer.domain;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class LibraryEvent {
    private Integer libraryEventId;
    private Book book;

    @Builder
    public LibraryEvent(Integer libraryEventId, Book book) {
        this.libraryEventId = libraryEventId;
        this.book = book;
    }
}
