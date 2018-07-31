package pl.autorun.library.services;

import pl.autorun.library.model.Book;

import java.util.Set;

public interface BookService {

    Set<Book> getBooks();

    void createBook(Book book);
}
