package com.xebia.uma.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.xebia.uma.model.Album;
import com.xebia.uma.repository.AlbumRepository;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class WebControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private AlbumRepository albumRepository;

//	@Before
//	public void setUp() {
//		Album album = new Album();
//		album.setArtist("uma");
//		album.setDescription("Uma is a singer");
//		album.setTitle("album");
//		albumRepository.save(album);
//	}

		
	@Test
	public void mockMvc_should_not_be_null() {
		Assertions.assertThat(mockMvc).isNotNull();
	}
	
	@Test
	public void testGetAllAlbums() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/api/albums").accept(MediaType.APPLICATION_JSON))
				.andDo(print());

	}

	/*
	 * private String createURLWithPort(String uri) { return "http://localhost:" +
	 * port + uri; }
	 */

	/*
	 * @Test public void testGetAlbumById() throws Exception {
	 * mockMvc.perform(MockMvcRequestBuilders.get("api/11/movies").accept(MediaType.
	 * APPLICATION_JSON)).andDo(print())
	 * .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1))
	 * .andExpect(MockMvcResultMatchers.jsonPath("$[0].confirmed").value(2222));
	 * 
	 * }
	 */

}
