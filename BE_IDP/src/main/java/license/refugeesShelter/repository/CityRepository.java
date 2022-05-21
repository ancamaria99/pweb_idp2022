package license.refugeesShelter.repository;

import license.refugeesShelter.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findByCityId(Long cityId);
}
