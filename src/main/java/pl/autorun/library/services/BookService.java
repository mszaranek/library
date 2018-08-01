package pl.autorun.library.services;

import pl.autorun.library.model.Book;

import java.util.Set;

public interface BookService {

    Set<Book> getBooks();

    void createBook(Book book);

    Book findBookById(Long l);

    Book updateBook(Book book);

    String deleteBook(Book book);
}
