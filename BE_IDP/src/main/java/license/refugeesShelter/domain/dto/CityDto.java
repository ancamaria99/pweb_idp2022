package license.refugeesShelter.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class CityDto {

    public Long cityId;

    public String name;

    @JsonProperty("country")
    public CountryDto countryDto;
}
