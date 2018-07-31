package pl.autorun.library.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.autorun.library.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
