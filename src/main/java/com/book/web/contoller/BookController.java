package com.book.web.contoller;

import com.book.web.model.Book;
import com.book.web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
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
    public String create(@ModelAttribute("book") Book book) {
        //bookRepo.addBook(book);
        bookService.create(book);
        return "redirect:/book";
    }

    @GetMapping
    public String getAllBooks(Model model) {
        //List<Book> bookList = bookRepo.getAll();
        List<Book> bookList = bookService.getAll();
        model.addAttribute("bookList", bookList);
        return "book/all";
    }
}
