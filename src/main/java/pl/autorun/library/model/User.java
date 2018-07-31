package pl.autorun.library.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "user")
    private Set<Book> books = new HashSet<>();

    public User(String username){
        this.username=username;
    }
}
