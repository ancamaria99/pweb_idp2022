package license.refugeesShelter.factory;

import license.refugeesShelter.domain.Shelter;
import license.refugeesShelter.domain.dto.ShelterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShelterFactory {

    private final CityFactory cityFactory;

    private final PhotoFactory photoFactory;

    public Shelter toEntity(ShelterDto shelterDto) {
        Shelter shelter = new Shelter();

        shelter.setName(shelterDto.getName());
        shelter.setDescription(shelterDto.getDescription());
        shelter.setPhone(shelterDto.getPhone());
        shelter.setNumberOfBookedSlots(shelterDto.getNumberOfBookedSlots());
        shelter.setTotalNumberOfSlots(shelterDto.getTotalNumberOfSlots());
        shelter.setPhoto(photoFactory.toEntity(shelterDto.getPhoto()));
        shelter.setCity(cityFactory.toEntity(shelterDto.getCityDto()));

        return shelter;
    }

}
