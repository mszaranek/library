package pl.autorun.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.autorun.library.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
