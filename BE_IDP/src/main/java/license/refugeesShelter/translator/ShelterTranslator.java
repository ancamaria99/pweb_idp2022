package license.refugeesShelter.translator;

import license.refugeesShelter.domain.Shelter;
import license.refugeesShelter.domain.dto.ShelterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ShelterTranslator {

    private final CityTranslator cityTranslator;

    private final PhotoTranslator photoTranslator;

    public ShelterDto generateShelterDto(Shelter shelter) {
        ShelterDto shelterDto = new ShelterDto();

        shelterDto.setShelterId(shelter.getShelterId());
        shelterDto.setName(shelter.getName());
        shelterDto.setDescription(shelter.getDescription());
        shelterDto.setPhone(shelter.getPhone());
        shelterDto.setNumberOfBookedSlots(shelter.getNumberOfBookedSlots());
        shelterDto.setTotalNumberOfSlots(shelter.getTotalNumberOfSlots());
        shelterDto.setPhoto(photoTranslator.generatePhotoDto(shelter.getPhoto()));
        shelterDto.setCityDto(cityTranslator.generateCityDto(shelter.getCity()));

        return shelterDto;
    }

    public List<ShelterDto> generateShelterDtoList(List<Shelter> shelters) {
        return shelters.stream().map(this::generateShelterDto).collect(Collectors.toList());
    }

}
