package license.refugeesShelter.translator;

import license.refugeesShelter.domain.User;
import license.refugeesShelter.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserTranslator {

    public UserDto generateUserDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setUserId(user.getUserId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setRoleType(user.getRoleType());

        return userDto;
    }

    public List<UserDto> generateUserDtoList(List<User> users) {
        return users.stream().map(this::generateUserDto).collect(Collectors.toList());
    }
}
