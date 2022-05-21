package license.refugeesShelter.service;

import license.refugeesShelter.domain.User;
import license.refugeesShelter.domain.dto.UserDto;
import license.refugeesShelter.factory.UserFactory;
import license.refugeesShelter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserFactory userFactory;

    public Optional<User> createUser(UserDto userDto) {
        return Optional.of(userRepository.save(userFactory.toEntity(userDto)));
    }

    public Optional<User> editUser(UserDto userDto) {
        return userRepository.findByUserId(userDto.getUserId())
                .map(user -> userRepository.save(user.updateFields(userDto)));
    }
}
