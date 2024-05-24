package co.develhope.eserc11CrudTest;

import co.develhope.eserc11CrudTest.entities.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(1)
    public void testCreateStudent() throws Exception {
        Student student = new Student();
        student.setName("Marco");
        student.setSurname("Ferraro");

        mockMvc.perform(post("/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Marco"));
    }

    @Test
    @Order(2)
    public void testGetAllStudents() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(3)
    public void testGetStudentById() throws Exception {
        mockMvc.perform(get("/students/1"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(4)
    public void testUpdateStudent() throws Exception {
        Student student = new Student();
        student.setName("Mario");
        student.setSurname("Rossi");

        mockMvc.perform(put("/students/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mario"));
    }

    @Test
    @Order(5)
    public void testUpdateIsWorking() throws Exception {
        mockMvc.perform(patch("/students/1/working")
                        .param("working", "true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.working").value(true));
    }

    @Test
    @Order(6)
    public void testDeleteStudent() throws Exception {
        mockMvc.perform(delete("/students/1"))
                .andExpect(status().isNoContent());
    }

}
