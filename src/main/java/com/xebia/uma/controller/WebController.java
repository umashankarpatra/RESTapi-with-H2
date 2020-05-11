package com.xebia.uma.controller;

import static com.xebia.uma.common.util.HeaderUtil.addError;
import static com.xebia.uma.common.util.HeaderUtil.addSuccess;
import static com.xebia.uma.common.util.RateMessageConstants.RECORD_STATUS_UPDATED_SUCCESSFULLY;
import static com.xebia.uma.common.util.RateMessageConstants.RECORD_STATUS_UPDATE_FAILED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.uma.model.album.dto.AlbumResponse;
import com.xebia.uma.model.album.dto.CreateAlbumRequest;
import com.xebia.uma.pagination.PaginatedResource;
import com.xebia.uma.pagination.PaginatedResourceAssembler;
import com.xebia.uma.repository.AlbumRepository;
import com.xebia.uma.service.AlbumService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.annotations.ApiIgnore;

@Slf4j
@RestController
public class WebController {

	@Autowired
	private AlbumService albumService;

	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private PaginatedResourceAssembler<AlbumResponse> pagedResourcesAssembler;

	@GetMapping("/api/albums")
	// @formatter:off
	@ApiOperation(nickname = "get-albums-page", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE, value = "Gets a page of Albums matching the selection filters and sort criteria", notes = "", response = PaginatedResource.class)
	public ResponseEntity<PaginatedResource<AlbumResponse>> getAllAlbums(
			@ApiParam(name = "artist", value = "Artist Name, ex. Sidhu Mooseaala, Babbu Maan", example = "Sidhu Mooseaala") @RequestParam(value = "artist", required = false) final String artist,
			@ApiIgnore @PageableDefault(page = 0, size = 2, sort = {
					"title" }, direction = Sort.Direction.ASC) final Pageable pageable) {
		// @formatter:on
		Page<AlbumResponse> results = this.albumService.getAlbums(artist, pageable);

		/*
		 * Optional<AlbumResponse> response = this.albumService.getAlbumsById(9);
		 * System.out.println("---->response" + response);
		 */

		if (results.isEmpty()) {
			HttpHeaders headers = new HttpHeaders();
			headers.add("X-info", "No Albums found matching given filters");
			return ResponseEntity.ok().headers(headers).build();
		} else {

			return ResponseEntity.ok(this.pagedResourcesAssembler.assemble(results));

		}

	}

	@GetMapping("/api/{id}/movies")
	// @formatter:off
	public ResponseEntity<Optional<AlbumResponse>> getAlbumById(
			@ApiParam(value = "Record id", example = "11", required = true) @PathVariable(name = "id", required = true) @NotEmpty final Long id) {
		// @formatter:on

		return ResponseEntity.ok(this.albumService.getAlbumsById(id));

	}

	@PutMapping("/api/movies/{id}/description")
	public ResponseEntity<Void> updateDescription(
			@ApiParam(value = "Record id", example = "123", required = true) @PathVariable(name = "id", required = true) @NotEmpty final Long id,
			@ApiParam(type = "String", value = "Action movie", required = true) @RequestParam(value = "description", required = true) @NotEmpty final String description) {

		log.info("Request for update description for Album : {}", id);
		Boolean updated = this.albumService.updateAlbumDescription(id, description);

		return ResponseEntity.ok().headers(
				updated ? addSuccess(RECORD_STATUS_UPDATED_SUCCESSFULLY) : addError(RECORD_STATUS_UPDATE_FAILED))
				.build();

	}

	@PostMapping("/api/movies")
	public void createAlbum(@RequestBody @Valid @NotEmpty final @NotNull CreateAlbumRequest createRequest) {

		log.info("Creatr request" + createRequest);
		
		this.albumService.cretaeAlbum(createRequest);

	}
}
