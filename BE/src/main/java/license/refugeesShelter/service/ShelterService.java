package license.refugeesShelter.service;

import license.refugeesShelter.domain.Photo;
import license.refugeesShelter.domain.Shelter;
import license.refugeesShelter.domain.dto.FilterShelterDto;
import license.refugeesShelter.domain.dto.ShelterDto;
import license.refugeesShelter.factory.ShelterFactory;
import license.refugeesShelter.repository.CityRepository;
import license.refugeesShelter.repository.ShelterRepository;
import license.refugeesShelter.translator.ShelterTranslator;
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

    private final ShelterFactory shelterFactory;

    private final CityRepository cityRepository;

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

    public Optional<Shelter> addNewShelter(ShelterDto shelterDto) {
        Shelter shelterToSave = shelterFactory.toEntity(shelterDto);

        shelterToSave.setCity(cityRepository.findByCityId(shelterToSave.getCity().getCityId()).get());

        return Optional.of(shelterRepository.save(shelterToSave));
    }

    public Shelter saveOrUpdate(Shelter shelter) {
        return shelterRepository.save(
                shelterRepository.findByShelterId(shelter.getShelterId())
                        .map(existingShelter -> existingShelter.updateFields(shelter))
                        .orElseGet(() -> shelter)
        );
    }

    public Optional<Shelter> editShelter(ShelterDto shelterDto) {
        Shelter updatedShelter = shelterFactory.toEntity(shelterDto);

        return shelterRepository.findByShelterId(shelterDto.shelterId)
                .map(existingShelter -> {
                    existingShelter.updateFields(updatedShelter);
                    return shelterRepository.save(updatedShelter);
                });
    }

    public Optional<Shelter> findShelter(Long shelterId) {
        return shelterRepository.findAll().stream().filter(shelter -> shelter.getShelterId().equals(shelterId)).findFirst();
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
