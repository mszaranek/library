package pl.autorun.library.services;

import org.springframework.stereotype.Service;
import pl.autorun.library.model.Book;
import pl.autorun.library.repositories.BookRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Set<Book> getBooks() {
        Set<Book> bookSet = new HashSet<>();

        bookRepository.findAll().iterator().forEachRemaining(bookSet::add);
        return bookSet;
    }

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);

    }
}
