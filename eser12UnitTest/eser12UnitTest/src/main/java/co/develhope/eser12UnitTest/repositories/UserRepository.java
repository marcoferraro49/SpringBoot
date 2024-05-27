package co.develhope.eser12UnitTest.repositories;

import co.develhope.eser12UnitTest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
