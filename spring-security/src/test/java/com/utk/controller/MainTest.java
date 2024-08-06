package com.utk.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class MainTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void helloUnauthenticated() throws Exception {
		mockMvc.perform(get("/hello")).andExpect(status().isUnauthorized());
	}

	@Test
	@WithMockUser
	public void helloAuthenticated() throws Exception {
		mockMvc.perform(get("/hello"))
				.andExpect(content().string(containsString("Hello Controller !!!!")))
				.andExpect(status().isOk());
	}
}
