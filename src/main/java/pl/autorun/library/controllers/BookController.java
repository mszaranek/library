package pl.autorun.library.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping(value = "/book/find", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> findBook(@RequestBody Book book) {


        if (bookService.findBookById(book.getId()) != null)
            return new ResponseEntity<>(bookService.findBookById(book.getId()), HttpStatus.OK);

        else
            return null;

    }

    @PostMapping(value = "/book/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        bookService.findBookById(book.getId());
        return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.OK);
    }

    @DeleteMapping(value = "/book/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteBook(@RequestBody Book book) {
        bookService.findBookById(book.getId());
        return new ResponseEntity<>(bookService.deleteBook(book), HttpStatus.OK);

    }
}
