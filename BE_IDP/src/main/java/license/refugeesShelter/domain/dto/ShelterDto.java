package license.refugeesShelter.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class ShelterDto {

    public Long shelterId;

    public String name;

    public String description;

    public String phone;

    public Long numberOfBookedSlots;

    public Long totalNumberOfSlots;

    public PhotoDto photo;

    @JsonProperty("city")
    public CityDto cityDto;
}
