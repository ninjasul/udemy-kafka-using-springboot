package com.udemy.kafka.library.events.producer.domain;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Book {
    private Integer bookId;
    private String bookName;
    private String bookAuthor;

    @Builder
    public Book(Integer bookId, String bookName, String bookAuthor) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }
}
