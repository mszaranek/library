package pl.autorun.library.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;


    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();


    @ManyToMany(mappedBy = "books")
    private Set<Genre> genres = new HashSet<>();

    public Book(String title, String isbn){
        this.title=title;
        this.isbn=isbn;
    }

    @ManyToOne
    private User user;
}
