package br.com.clickbus.challenge.service;

import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;
import br.com.clickbus.challenge.dto.PlaceDTO;
import br.com.clickbus.challenge.entity.Place;
import br.com.clickbus.challenge.repository.PlaceRepository;

@Service
public class PlaceService {

	private PlaceRepository placeRepository;

	public List<Place> findAll() {
		throw new NotImplementedException("Metodo nao implementado");
	}

	public Optional<Place> findById(@NotNull final Long id) {
		return placeRepository.findById(id);
	}

	public Place save(@NotNull final Place place) {
		return placeRepository.save(place);
	}

	public List<Place> findByName(@NotNull final String name) {
		return placeRepository.findByName(name);
	}

	public Place alter(@NotNull final Place place, @NotNull final PlaceDTO placeDTO) {
		return placeRepository.save(place.of(placeDTO));
	}

	/**
	 * Recupera o valor do campo repository.
	 *
	 * @return valor do campo repository.
	 */
	public PlaceRepository getRepository() {
		return placeRepository;
	}

	/**
	 * Atribui o valor do parâmetro repository para o campo repository.
	 *
	 * @param valor
	 *            para o campo repository.
	 */
	public void setRepository(final PlaceRepository repository) {
		placeRepository = repository;
	}
}
