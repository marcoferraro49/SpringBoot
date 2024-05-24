package co.develhope.eserc11CrudTest.repositories;

import co.develhope.eserc11CrudTest.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
