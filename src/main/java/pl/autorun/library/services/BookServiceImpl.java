package pl.autorun.library.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.autorun.library.model.Book;
import pl.autorun.library.model.DTO.BookDTO;
import pl.autorun.library.repositories.BookRepository;

import java.util.HashSet;
import java.util.Optional;
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
        return Optional.ofNullable(bookRepository.findById(l)).get().get();
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
