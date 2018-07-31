package pl.autorun.library.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.autorun.library.model.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
}
