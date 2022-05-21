package license.refugeesShelter.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class CountryDto {

    public Long countryId;

    public String name;
}
