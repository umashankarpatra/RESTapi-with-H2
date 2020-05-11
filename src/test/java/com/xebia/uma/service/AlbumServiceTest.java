package com.xebia.uma.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.xebia.uma.common.exception.ResourceNotFoundException;
import com.xebia.uma.repository.AlbumRepository;
import com.xebia.uma.repository.MovieRepository;

@RunWith(PowerMockRunner.class)
@SpringBootTest
public class AlbumServiceTest {

	@InjectMocks
	private AlbumServiceImpl albumService;

	@Mock
	private AlbumRepository albumRepository;
	
	@Mock
	private MovieRepository movieRepository;
	
    @Rule
    private ExpectedException expectedExceptionRule = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAlbum() {
		// albumService.m1("uma");
		
		when(albumRepository.test()).thenReturn("uma");
		assertEquals(albumService.m1("uma"), "uma");

	}
	
    @Test
    public void testUpdateResourceNotFoundException() {
        expectedExceptionRule.expect(ResourceNotFoundException.class);
        expectedExceptionRule.expectMessage("Employee not found for this id :: ");
     
        
        when(movieRepository.findById((long) 100)).thenReturn(Optional.empty());
        albumService.createMovies();
    }

}
