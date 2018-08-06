package pl.autorun.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.autorun.library.model.Book;


public interface BookRepository extends JpaRepository<Book, Long> {

}
