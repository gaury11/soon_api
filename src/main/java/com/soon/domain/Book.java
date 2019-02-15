package com.soon.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class Book {

    private Integer idx;
    private String title;
    private LocalDateTime publishedAt;

    @Builder
    public Book(String titile, LocalDateTime publishedAt){
        this.title = titile;
        this.publishedAt = publishedAt;
    }


}
