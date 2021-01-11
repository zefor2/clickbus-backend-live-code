package br.com.clickbus.challenge.dto;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import br.com.clickbus.challenge.entity.Place;

public class PlaceDTO {

	@NotNull
	private String name;

	@NotNull
	private String slug;

	@NotNull
	private String city;

	@NotNull
	private String state;

	public PlaceDTO(final String name, final String slug, final String city, final String state) {
		this.name = name;
		this.slug = slug;
		this.city = city;
		this.state = state;
	}

	public static PlaceDTO of(final String name, final String slug, final String city, final String state) {
		return new PlaceDTO(name, slug, city, state);
	}

	public static Iterable<PlaceDTO> convertToList(final List<Place> places) {
		return places.stream().map(Place::convertToDTO).collect(Collectors.toList());
	}

	public Place buildPlace() {
		return Place.of(name, slug, city, state);
	}

	/**
	 * Recupera o valor do campo name.
	 * 
	 * @return valor do campo name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Atribui o valor do parâmetro name para o campo name.
	 * 
	 * @param valor
	 *            para o campo name.
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Recupera o valor do campo slug.
	 * 
	 * @return valor do campo slug.
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * Atribui o valor do parâmetro slug para o campo slug.
	 * 
	 * @param valor
	 *            para o campo slug.
	 */
	public void setSlug(final String slug) {
		this.slug = slug;
	}

	/**
	 * Recupera o valor do campo city.
	 * 
	 * @return valor do campo city.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Atribui o valor do parâmetro city para o campo city.
	 * 
	 * @param valor
	 *            para o campo city.
	 */
	public void setCity(final String city) {
		this.city = city;
	}

	/**
	 * Recupera o valor do campo state.
	 * 
	 * @return valor do campo state.
	 */
	public String getState() {
		return state;
	}

	/**
	 * Atribui o valor do parâmetro state para o campo state.
	 * 
	 * @param valor
	 *            para o campo state.
	 */
	public void setState(final String state) {
		this.state = state;
	}
}
