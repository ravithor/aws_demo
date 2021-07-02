package com.cognizant.springwstest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class SpringWsTestApplicationTests {
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	UserService mockService;

	@Test
	public void greetNameReturnOk() throws Exception{
		mvc.perform(get("/api/Thor"))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	public void greetNameReturnsContent() throws Exception{
		mvc.perform(get("/api/Thor"))
		.andDo(print())
		.andExpect(content().string(containsString("Thor")));
	}
	
	@Test
	public void testAddUser() throws Exception{
		User user = new User();
		user.setName("Ravi");
		user.setAge(21);
		when(mockService.addUser(user)).thenReturn(user);
		mvc.perform(post("/api/").content("{\"name\":\"Ravi\",\"age\":21}")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk());
	}

}
