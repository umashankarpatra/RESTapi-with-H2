package com.xebia.linksharing.controller;



import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xebia.linksharing.model.Link;
import com.xebia.linksharing.model.link.dto.LinkRequest;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class LinkControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;


	@Test
	public void mockMvc_should_not_be_null() {
		Assertions.assertThat(mockMvc).isNotNull();
	}

	@Test
	public void testGetAllLinks() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/web-links").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());

	}

	@Test
	public void testGetAlbumById() throws Exception { // long id=(long)1;
		mockMvc.perform(MockMvcRequestBuilders.get("/api/1/albums").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());

	}

	@Test
	public void testCreateLink() throws Exception {
		LinkRequest request=new LinkRequest();
		request.setUrl("https://www.snowpack.dev/posts/2020-05-26-snowpack-2-0-release");
		request.setTitle("Snowpack 2.0 Release");
		String json = objectMapper.writeValueAsString(request);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/web-links").contentType(MediaType.APPLICATION_JSON).content(json))
				.andDo(print()).andExpect(status().isCreated());

	}

}
