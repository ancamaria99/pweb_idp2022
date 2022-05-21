package license.refugeesShelter.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class PhotoDto {

    public Long photoId;

    @JsonProperty("photoFile")
    public byte[] photo;
}
