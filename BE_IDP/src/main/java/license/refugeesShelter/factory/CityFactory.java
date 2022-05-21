package license.refugeesShelter.factory;

import license.refugeesShelter.domain.City;
import license.refugeesShelter.domain.dto.CityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CityFactory {

    private final CountryFactory countryFactory;

    public City toEntity(CityDto cityDto) {
        City city = new City();

        city.setCityId(cityDto.getCityId());
        city.setName(cityDto.getName());
        city.setCountry(countryFactory.toEntity(cityDto.countryDto));

        return city;
    }
}
