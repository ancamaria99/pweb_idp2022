package license.refugeesShelter.repository;

import license.refugeesShelter.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Optional<Country> findByCountryId(Long countryId);

}
