package license.refugeesShelter.translator;

import license.refugeesShelter.domain.City;
import license.refugeesShelter.domain.dto.CityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CityTranslator {

    private final CountryTranslator countryTranslator;

    public CityDto generateCityDto(City city) {
        CityDto cityDto = new CityDto();

        cityDto.setCityId(city.getCityId());
        cityDto.setName(city.getName());
        cityDto.setCountryDto(countryTranslator.generateCountryDto(city.getCountry()));

        return cityDto;
    }

    public List<CityDto> generateCityDtoList(List<City> cities) {
        return cities.stream().map(this::generateCityDto).collect(Collectors.toList());
    }
}
