package pl.autorun.library.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.autorun.library.converter.Converter;
import pl.autorun.library.model.DTO.BookDTO;
import pl.autorun.library.services.BookService;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    private final BookService bookService;
    private final Converter converter;

    public BookController(BookService bookService, Converter converter) {
        this.bookService = bookService;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<Set<BookDTO>> showBooks() {
        return new ResponseEntity<>(bookService.getBooks().stream()
                .map(book -> converter.convertBookToDto(book))
                .collect(Collectors.toSet()), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody BookDTO bookDTO) {
        bookService.createBook(converter.convertDtoToBook(bookDTO));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDTO> findBook(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(converter.convertBookToDto(bookService.findBookById(id)), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateBook(@RequestBody BookDTO bookDTO) {
        bookService.findBookById(bookDTO.getId());
        bookService.updateBook(converter.convertDtoToBook(bookDTO));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable(value = "id") Long id) {
        bookService.deleteBook(bookService.findBookById(id));
    }
}
