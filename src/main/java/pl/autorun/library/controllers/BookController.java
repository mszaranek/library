package pl.autorun.library.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.autorun.library.model.Book;
import pl.autorun.library.services.BookService;

import java.util.Set;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/book/show")
    public ResponseEntity<Set<Book>> showBooks() {

        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @PostMapping(value = "/book/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> createBook(@RequestBody Book book) {

        bookService.createBook(book);

        return new ResponseEntity<>(book, HttpStatus.CREATED);

    }
}
