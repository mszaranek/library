package pl.autorun.library.model.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private Set<BookDTO> books;
}
