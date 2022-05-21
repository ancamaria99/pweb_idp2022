package license.refugeesShelter.service;

import license.refugeesShelter.domain.Photo;
import license.refugeesShelter.domain.Shelter;
import license.refugeesShelter.domain.dto.FilterShelterDto;
import license.refugeesShelter.repository.ShelterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShelterService {

    private final ShelterRepository shelterRepository;

    private final PhotoService photoService;

    public boolean uploadPhoto(Long shelterId, MultipartFile photo) {
        Optional<Shelter> existingShelter = shelterRepository.findById(shelterId);
        Optional<Photo> savedPhoto = photoService.savePhoto(photo);

        if (existingShelter.isEmpty() || savedPhoto.isEmpty()) {
            return false;
        }

        existingShelter.ifPresent(shelter -> {
            shelter.setPhoto(savedPhoto.get());
            saveOrUpdate(shelter);
        });

        return true;
    }

    public Shelter saveOrUpdate(Shelter shelter) {
        return shelterRepository.save(
                shelterRepository.findByShelterId(shelter.getShelterId())
                        .map(existingShelter -> existingShelter.updateFields(shelter))
                        .orElseGet(() -> shelter)
        );
    }

    public List<Shelter> getSheltersFiltered(FilterShelterDto filterShelterDto) {
        return shelterRepository.findAll().stream().filter(shelter -> doesShelterMatchAllFilters(shelter, filterShelterDto)).collect(Collectors.toList());
    }

    public boolean doesShelterMatchAllFilters(Shelter shelter, FilterShelterDto filterShelterDto) {
        if (!Objects.isNull(filterShelterDto.getCountryName()) && !shelter.getCity().getCountry().getName().equals(filterShelterDto.getCountryName())) {
            return false;
        }

        if (!Objects.isNull(filterShelterDto.getCityName()) && !shelter.getCity().getName().equals(filterShelterDto.getCityName())) {
            return false;
        }

        return true;
    }
}
