package pl.autorun.library.services;


import org.springframework.stereotype.Service;
import pl.autorun.library.exceptions.NotFoundException;
import pl.autorun.library.model.Book;
import pl.autorun.library.repositories.AuthorRepository;
import pl.autorun.library.repositories.BookRepository;
import pl.autorun.library.repositories.GenreRepository;
import pl.autorun.library.repositories.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;
    private final UserRepository userRepository;

    public BookServiceImpl(BookRepository bookRepository, GenreRepository genreRepository,
                           AuthorRepository authorRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
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

    @Override
    public Book findBookById(Long l) {

        Optional<Book> bookOptional = bookRepository.findById(l);

        if (!bookOptional.isPresent()) {
            throw new NotFoundException("Book not found");
        } else

            return bookOptional.get();
    }

    @Override
    public Book updateBook(Book book) {

        bookRepository.save(book);
        return book;
    }

    @Override
    public String deleteBook(Book book) {


        bookRepository.delete(book);

        return "Book has been deleted";
    }
}
