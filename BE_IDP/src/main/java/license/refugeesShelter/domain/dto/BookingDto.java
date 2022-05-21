package license.refugeesShelter.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class BookingDto {

    private Long bookingId;

    private String name;

    private float averagePricePerNightPerPerson;

    private String link;
}
