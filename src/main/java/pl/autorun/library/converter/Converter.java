package pl.autorun.library.converter;

import org.springframework.stereotype.Service;
import pl.autorun.library.model.Author;
import pl.autorun.library.model.Book;
import pl.autorun.library.model.DTO.AuthorDTO;
import pl.autorun.library.model.DTO.BookDTO;
import pl.autorun.library.model.DTO.GenreDTO;
import pl.autorun.library.model.DTO.UserDTO;
import pl.autorun.library.model.Genre;
import pl.autorun.library.model.User;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Converter {

    public BookDTO convertBookToDto(Book book) {
        if (book == null) {
            return null;
        }
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthors(Optional.ofNullable(book.getAuthors()).get().stream()
                .map(author -> convertAuthorToDto(author))
                .collect(Collectors.toSet()));
        bookDTO.setGenres(Optional.ofNullable(book.getGenres()).get().stream()
                .map(genre -> convertGenreToDto(genre))
                .collect(Collectors.toSet()));
        return bookDTO;
    }


    public Book convertDtoToBook(BookDTO bookDTO) {
        if (bookDTO == null) {
            return null;
        }
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setIsbn(bookDTO.getIsbn());
        book.setTitle(bookDTO.getTitle());
        book.setAuthors(Optional.ofNullable(bookDTO.getAuthors()).get().stream()
                .map(authorDTO -> convertDtoToAuthor(authorDTO))
                .collect(Collectors.toSet()));
        book.setGenres(Optional.ofNullable(bookDTO.getGenres()).get().stream()
                .map(genreDTO -> convertDtoToGenre(genreDTO))
                .collect(Collectors.toSet()));
        return book;
    }

    public AuthorDTO convertAuthorToDto(Author author) {
        if (author == null) {
            return null;
        }
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setFirstName(author.getFirstName());
        authorDTO.setLastName(author.getLastName());
        authorDTO.setBooks(null);
        return authorDTO;

    }

    public Author convertDtoToAuthor(AuthorDTO authorDTO) {
        if (authorDTO == null) {
            return null;
        }
        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        author.setBooks(Optional.ofNullable(authorDTO.getBooks()).get().stream()
                .map(bookDTO -> convertDtoToBook(bookDTO))
                .collect(Collectors.toSet()));
        return author;
    }

    public GenreDTO convertGenreToDto(Genre genre) {
        if (genre == null) {
            return null;
        }
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genre.getId());
        genreDTO.setName(genre.getName());
        genreDTO.setBooks(null);
        return genreDTO;
    }

    public Genre convertDtoToGenre(GenreDTO genreDTO) {
        if (genreDTO == null) {
            return null;
        }
        Genre genre = new Genre();
        genre.setId(genreDTO.getId());
        genre.setName(genreDTO.getName());
        genre.setBooks(Optional.ofNullable(genreDTO.getBooks()).get().stream()
                .map(bookDTO -> convertDtoToBook(bookDTO))
                .collect(Collectors.toSet()));
        return genre;
    }

    public UserDTO convertUserToDto(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setBooks(Optional.ofNullable(user.getBooks()).get().stream()
                .map(book -> convertBookToDto(book))
                .collect(Collectors.toSet()));
        return userDTO;
    }

    public User convertDtoToUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setBooks(Optional.ofNullable(userDTO.getBooks()).get().stream()
                .map(bookDTO -> convertDtoToBook(bookDTO))
                .collect(Collectors.toSet()));
        return user;
    }


}

