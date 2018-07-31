package pl.autorun.library.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.autorun.library.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
