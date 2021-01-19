package com.book.web.service.mapper;

import com.book.web.model.Book;
import com.book.web.model.dto.BookRequestDto;
import com.book.web.model.dto.BookResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class BookMapper {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");

    public Book mapToModel(BookRequestDto bookRequestDto){
        Book book = new Book();
        book.setName(bookRequestDto.getName());
        book.setAuthor(bookRequestDto.getAuthor());
        book.setDateOfIssue(LocalDate.parse(bookRequestDto.getDateOfIssue(), formatter));
        book.setPrice(bookRequestDto.getPrice());
        return book;
    }

    public BookResponseDto mapToDto(Book book) {
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setName(book.getName());
        bookResponseDto.setAuthor(book.getAuthor());
        bookResponseDto.setDateOfIssue(book.getDateOfIssue().format(formatter));
        bookResponseDto.setPrice(book.getPrice());
        return bookResponseDto;
    }
}
