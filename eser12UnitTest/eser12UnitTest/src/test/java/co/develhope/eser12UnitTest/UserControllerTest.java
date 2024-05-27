package co.develhope.eser12UnitTest;

import co.develhope.eser12UnitTest.entities.User;
import co.develhope.eser12UnitTest.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private UserRepository userRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@Order(1)
	public void testCreateUser() throws Exception {
		User user = new User();
		user.setId(1L);
		user.setUsername("willy");
		user.setEmail("willy@email.it");

		mockMvc.perform(post("/users")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(user)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.username").value("willy"));
	}

	@Test
	@Order(2)
	public void testGetUserById() throws Exception {
		mockMvc.perform(get("/users/1"))
				.andExpect(status().isOk());
	}

	@Test
	@Order(3)
	public void testUpdate() throws Exception {
		User existingUser = new User();
		existingUser.setId(1L);
		existingUser.setEmail("test@email.it");
		existingUser.setUsername("test");

		User updatedUser = new User();
		updatedUser.setUsername("test1");
		updatedUser.setEmail("test1@email.it");

		when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
		when(userRepository.saveAndFlush(any(User.class))).thenReturn(updatedUser);

		Optional<User> optionalUser = userRepository.findById(1L);
		User userToUpdate = optionalUser.orElseThrow(() -> new Exception("User non trovato"));
		userToUpdate.setUsername(updatedUser.getUsername());
		userToUpdate.setEmail(updatedUser.getEmail());
		User savedUser = userRepository.saveAndFlush(userToUpdate);

		assertEquals("test1", savedUser.getUsername());
		assertEquals("test1@email.it", savedUser.getEmail());

		verify(userRepository).findById(1L);
		verify(userRepository).saveAndFlush(userToUpdate);
	}

	@Test
	@Order(4)
	public void testDeleteUser() throws Exception {
		User user = new User();
		user.setId(1L);
		user.setEmail("test@email.it");
		user.setUsername("willy");

		when(userRepository.findById(1L)).thenReturn(Optional.of(user));
		userRepository.deleteById(1L);
	}

}
