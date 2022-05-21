package license.refugeesShelter.factory;

import license.refugeesShelter.domain.Country;
import license.refugeesShelter.domain.dto.CountryDto;
import org.springframework.stereotype.Component;

@Component
public class CountryFactory {

    public Country toEntity(CountryDto countryDto) {
        Country country = new Country();

        country.setCountryId(countryDto.getCountryId());
        country.setName(country.getName());

        return country;
    }
}
