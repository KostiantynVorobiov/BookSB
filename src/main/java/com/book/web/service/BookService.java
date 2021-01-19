package com.book.web.service;

import com.book.web.model.Book;

import java.util.List;

public interface BookService {
    Book create(Book book);

    List<Book> getAll();
}
