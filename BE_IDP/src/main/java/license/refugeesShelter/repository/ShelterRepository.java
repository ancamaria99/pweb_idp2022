package license.refugeesShelter.repository;

import license.refugeesShelter.domain.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {
    Optional<Shelter> findByShelterId(Long shelterId);

    List<Shelter> findAll();
}