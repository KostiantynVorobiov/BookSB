package com.book.web.model.dto;

import lombok.Data;

@Data
public class BookRequestDto {
    private String name;
    private String author;
    private String dateOfIssue;
    private Double price;
}
