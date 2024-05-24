package co.develhope.eserc11CrudTest;
import co.develhope.eserc11CrudTest.entities.Student;
import co.develhope.eserc11CrudTest.repositories.StudentRepository;
import co.develhope.eserc11CrudTest.services.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @Test
    public void testCreateStudent() {
        Student student = new Student();
        student.setName("Marco");
        student.setSurname("Ferraro");
        when(studentRepository.save(student)).thenReturn(student);

        Student created = studentService.createStudent(student);
        assertThat(created.getName()).isEqualTo("Marco");
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void testGetStudentById() {
        Student student = new Student();
        student.setId(1L);
        student.setName("Marco");
        when(studentRepository.findById(anyLong())).thenReturn(Optional.of(student));

        Optional<Student> found = studentService.getStudentById(1L);
        assertThat(found).isPresent();
        assertThat(found.get().getId()).isEqualTo(1L);
    }

    @Test
    public void testUpdateIsWorking() {
        Student student = new Student();
        student.setId(1L);
        student.setWorking(false);
        when(studentRepository.findById(anyLong())).thenReturn(Optional.of(student));

        studentService.updateIsWorking(1L, true);
        assertThat(student.isWorking()).isTrue();
    }
}
