package pl.autorun.library.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.spi.CascadingAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books  = new HashSet<>();

    public Author(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }
}
