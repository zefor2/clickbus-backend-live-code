package br.com.clickbus.challenge.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.clickbus.challenge.entity.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

	List<Place> findByName(String name);

}
