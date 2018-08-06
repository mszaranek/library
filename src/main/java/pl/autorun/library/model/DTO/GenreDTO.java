package pl.autorun.library.model.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class GenreDTO {
    private Long id;
    private String name;
    private Set<BookDTO> books;

}
