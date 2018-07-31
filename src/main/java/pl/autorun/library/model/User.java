package pl.autorun.library.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "user")
    private Set<Book> books = new HashSet<>();

    public User(){}

    public User(String username){
        this.username=username;
    }
}
