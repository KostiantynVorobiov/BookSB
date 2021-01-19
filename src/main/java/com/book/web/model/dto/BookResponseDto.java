package com.book.web.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookResponseDto {
    private Long id;
    private String name;
    private String author;
    private String dateOfIssue;
    private Double price;
}
