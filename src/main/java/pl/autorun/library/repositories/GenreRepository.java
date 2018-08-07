package pl.autorun.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.autorun.library.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
