package com.book.web.service;

import com.book.web.model.Book;
import com.book.web.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class BookServiceImplTest {
    private final BookRepository repository = Mockito.mock(BookRepository.class);
    private final BookService service = new BookServiceImpl(repository);

    @Test
    void create() {
        Book kobzar = new Book();
        kobzar.setAuthor("Shevshenko");
        kobzar.setName("Kobzar");
        kobzar.setDateOfIssue(LocalDate.of(1860, 03, 03));
        kobzar.setPrice(150.50);
        when(repository.save(kobzar)).thenReturn(kobzar);
        Book actual = service.create(kobzar);
        assertEquals(kobzar, actual);
    }

    @Test
    void getAll() {
        Book kobzar = new Book();
        kobzar.setAuthor("Shevshenko");
        kobzar.setName("Kobzar");
        kobzar.setDateOfIssue(LocalDate.of(1860, 03, 03));
        kobzar.setPrice(150.50);
        Book pisnya = new Book();
        pisnya.setAuthor("Lesya Ykrainka");
        pisnya.setName("Lisova Pisnya");
        pisnya.setDateOfIssue(LocalDate.of(1800, 01, 07));
        pisnya.setPrice(100.99);
        List<Book> bookList = new ArrayList<>();
        bookList.add(kobzar);
        bookList.add(pisnya);
        when(repository.findAll()).thenReturn(bookList);
        List<Book> actual = service.getAll();
        assertEquals(bookList, actual);
    }
}
