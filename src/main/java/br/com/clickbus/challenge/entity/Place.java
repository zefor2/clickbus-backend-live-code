package br.com.clickbus.challenge.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import br.com.clickbus.challenge.dto.PlaceDTO;

@Entity
public class Place {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private String slug;

	@NotNull
	private String city;

	@NotNull
	private String state;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	public Place(final String name, final String slug, final String city, final String state) {
		this.name = name;
		this.slug = slug;
		this.city = city;
		this.state = state;
		createdAt = LocalDateTime.now();
	}

	public Place of(final PlaceDTO placeDTO) {
		name = placeDTO.getName();
		slug = placeDTO.getSlug();
		city = placeDTO.getCity();
		state = placeDTO.getState();
		updatedAt = LocalDateTime.now();
		return this;
	}

	public static Place of(final String name, final String slug, final String city, final String state) {
		return new Place(name, slug, city, state);
	}

	public PlaceDTO convertToDTO() {
		return PlaceDTO.of(name, slug, city, state);
	}

	/**
	 * Recupera o valor do campo id.
	 *
	 * @return valor do campo id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Atribui o valor do parâmetro id para o campo id.
	 *
	 * @param valor
	 *            para o campo id.
	 */
	public void setId(final Long id) {
		this.id = id;
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

	/**
	 * Recupera o valor do campo createdAt.
	 *
	 * @return valor do campo createdAt.
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	/**
	 * Atribui o valor do parâmetro createdAt para o campo createdAt.
	 *
	 * @param valor
	 *            para o campo createdAt.
	 */
	public void setCreatedAt(final LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Recupera o valor do campo updatedAt.
	 *
	 * @return valor do campo updatedAt.
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * Atribui o valor do parâmetro updatedAt para o campo updatedAt.
	 *
	 * @param valor
	 *            para o campo updatedAt.
	 */
	public void setUpdatedAt(final LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
