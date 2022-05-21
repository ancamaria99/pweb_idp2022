package license.refugeesShelter.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import license.refugeesShelter.domain.enums.RoleType;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class UserDto {

    public Long userId;

    public String firstName;

    public String lastName;

    public String email;

    public RoleType roleType;
}
