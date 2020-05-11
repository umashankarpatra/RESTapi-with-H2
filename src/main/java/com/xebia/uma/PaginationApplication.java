package com.xebia.uma;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ForwardedHeaderFilter;

import com.xebia.uma.infra.config.ApplicationProperties;
import com.xebia.uma.model.Album;
import com.xebia.uma.repository.AlbumRepository;

@SpringBootApplication
@EnableConfigurationProperties({ ApplicationProperties.class })
public class PaginationApplication {

	@Autowired
	private AlbumRepository albumRepository;

	public static void main(String[] args) {
		SpringApplication.run(PaginationApplication.class, args);
	}

	@Bean
	ForwardedHeaderFilter forwardedHeaderFilter() {
		return new ForwardedHeaderFilter();
	}

	@PostConstruct
	private void initDb() {
		Album album = new Album();
		album.setArtist("uma");
		album.setDescription("Uma is a singer");
		album.setTitle("album");
		albumRepository.save(album);
	}

}
