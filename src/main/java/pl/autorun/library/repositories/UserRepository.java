package pl.autorun.library.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.autorun.library.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
