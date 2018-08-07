package pl.autorun.library.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.autorun.library.exceptions.NotFoundException;
import pl.autorun.library.model.Book;
import pl.autorun.library.repositories.BookRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Set<Book> getBooks() {
        return new HashSet<>(bookRepository.findAll());
    }

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findBookById(Long l) {
        return bookRepository.findById(l).orElseThrow((() -> new NotFoundException("Book not found")));
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }
}
