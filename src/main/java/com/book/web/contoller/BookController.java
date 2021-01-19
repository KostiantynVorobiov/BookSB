package com.book.web.contoller;

import com.book.web.model.Book;
import com.book.web.model.dto.BookRequestDto;
import com.book.web.model.dto.BookResponseDto;
import com.book.web.service.BookService;
import com.book.web.service.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;

    @Autowired
    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping("/inject")
    public String inject() {
        Book kobzar = new Book();
        kobzar.setAuthor("Shevshenko");
        kobzar.setName("Kobzar");
        kobzar.setDateOfIssue(LocalDate.of(1860, 03, 03));
        kobzar.setPrice(150.50);
        //bookRepo.addBook(kobzar);
        bookService.create(kobzar);

        Book bibliya = new Book();
        bibliya.setAuthor("Matveyu");
        bibliya.setName("Bibliya");
        bibliya.setDateOfIssue(LocalDate.of(5, 01, 07));
        bibliya.setPrice(10000000.99);
        //bookRepo.addBook(bibliya);
        bookService.create(bibliya);
        return "book/ok";
    }

    @GetMapping("/new")
    public String newBookForm(@ModelAttribute("book") Book book) {
        return "book/new";
    }

    @PostMapping
    public String create(@ModelAttribute("book") BookRequestDto bookRequestDto) {
        Book book = bookMapper.mapToModel(bookRequestDto);
        bookService.create(book);
        return "redirect:/book";
    }

    @GetMapping
    public String getAllBooks(Model model) {
        List<BookResponseDto> bookList = bookService.getAll().stream()
                .map(bookMapper::mapToDto)
                .collect(Collectors.toList());
        model.addAttribute("bookList", bookList);
        return "book/all";
    }
}
