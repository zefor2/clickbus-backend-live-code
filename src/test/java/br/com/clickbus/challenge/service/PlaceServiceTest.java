package br.com.clickbus.challenge.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import br.com.clickbus.challenge.dto.PlaceDTO;
import br.com.clickbus.challenge.entity.Place;
import br.com.clickbus.challenge.repository.PlaceRepository;

@ExtendWith(MockitoExtension.class)
class PlaceServiceTest {

	public static final String NAME_PLACE = "Butanta";

	@Mock
	private PlaceRepository repository;

	@InjectMocks
	private PlaceService service;

	private Place place;

	@BeforeEach
	void setUp() {
		place = Place.of(PlaceServiceTest.NAME_PLACE, "bt", "Sao Paulo", "SP");
	}

	@Test
	void whenFindByIdOk() {
		Mockito.when(repository.findById(1L)).thenReturn(Optional.of(place));

		final Place actual = service.findById(1L).get();

		Assertions.assertEquals(place.getName(), actual.getName());
		Assertions.assertEquals(place.getSlug(), actual.getSlug());
		Assertions.assertEquals(place.getCity(), actual.getCity());
		Assertions.assertEquals(place.getState(), actual.getState());
		Assertions.assertEquals(place.getCreatedAt(), actual.getCreatedAt());
		Assertions.assertNull(actual.getUpdatedAt());
		Mockito.verify(repository, Mockito.atLeastOnce()).findById(ArgumentMatchers.anyLong());
	}

	@Test
	void whenFindByIdThenReturnEmpty() {
		Mockito.when(repository.findById(1L)).thenReturn(Optional.empty());

		Assertions.assertFalse(service.findById(1L).isPresent());
		Mockito.verify(repository, Mockito.atLeastOnce()).findById(ArgumentMatchers.anyLong());
	}

	@Test
	void whenFindByNameOk() {
		Mockito.when(repository.findByName(PlaceServiceTest.NAME_PLACE)).thenReturn(Collections.singletonList(place));

		final List<Place> actual = service.findByName(PlaceServiceTest.NAME_PLACE);

		Assertions.assertEquals(1, actual.size());
		Mockito.verify(repository, Mockito.atLeastOnce()).findByName(PlaceServiceTest.NAME_PLACE);
	}

	@Test
	void whenFindByNameNotFound() {
		Mockito.when(repository.findByName(PlaceServiceTest.NAME_PLACE)).thenReturn(null);

		Assertions.assertNull(service.findByName(PlaceServiceTest.NAME_PLACE));
		Mockito.verify(repository, Mockito.atLeastOnce()).findByName(PlaceServiceTest.NAME_PLACE);
	}

	@Test
	void whenSaveOk() {
		Mockito.when(repository.save(ArgumentMatchers.any(Place.class))).thenReturn(place);

		final Place actual = service.save(place);

		Assertions.assertEquals(place, actual);
		Mockito.verify(repository, Mockito.atLeastOnce()).save(ArgumentMatchers.any(Place.class));
	}

	@Test
	void whenAlterPlaceOk() {
		final String editedName = "Lorem Ipsum";
		final PlaceDTO placeDTO = PlaceDTO.of(editedName, place.getSlug(), place.getCity(), place.getState());
		Mockito.when(repository.save(ArgumentMatchers.any(Place.class))).thenReturn(place);

		final Place edited = service.alter(place, placeDTO);

		Assertions.assertNotNull(edited);
		Assertions.assertEquals(editedName, edited.getName());
		Assertions.assertEquals(place.getSlug(), edited.getSlug());
		Assertions.assertEquals(place.getCity(), edited.getCity());
		Assertions.assertEquals(place.getCreatedAt(), edited.getCreatedAt());
		Assertions.assertNotNull(edited.getUpdatedAt());
	}
}
