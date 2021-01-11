package br.com.clickbus.challenge.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.clickbus.challenge.dto.PlaceDTO;
import br.com.clickbus.challenge.entity.Place;
import br.com.clickbus.challenge.exception.PlaceNotFoundException;
import br.com.clickbus.challenge.service.PlaceService;
import io.swagger.annotations.Api;

@Api("places")
@RestController
@RequestMapping("places")
public class PlaceController {

	@Autowired
	private PlaceService placeService;

	@PostMapping
	public ResponseEntity create(@RequestBody @Valid final PlaceDTO dto) {
		return new ResponseEntity(placeService.save(dto.buildPlace()).convertToDTO(), HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity findById(@PathVariable final Long id) {
		return placeService.findById(id).map(place -> ResponseEntity.ok(place.convertToDTO()))
				.orElseThrow(() -> new PlaceNotFoundException(HttpStatus.NOT_FOUND));
	}

	@GetMapping
	public ResponseEntity findAll() {
		final Iterable<PlaceDTO> places = PlaceDTO.convertToList(placeService.findAll());
		return ResponseEntity.ok(places);
	}

	@GetMapping("/")
	public ResponseEntity findByName(@RequestParam(name = "name") final String name) {
		final Iterable<PlaceDTO> places = PlaceDTO.convertToList(placeService.findByName(name));
		return ResponseEntity.ok(places);
	}

	@PutMapping("/{id}")
	public ResponseEntity alter(@PathVariable final Long id, @RequestBody @Valid final PlaceDTO placeDTO) {
		final Place place = placeService.findById(id).orElseThrow(null);
		return new ResponseEntity(placeService.alter(place, placeDTO).convertToDTO(), HttpStatus.OK);
	}
}
