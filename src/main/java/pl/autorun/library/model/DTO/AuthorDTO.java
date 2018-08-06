package pl.autorun.library.model.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<BookDTO> books;
}
