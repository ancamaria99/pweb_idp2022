package license.refugeesShelter.service;

import license.refugeesShelter.domain.Photo;
import license.refugeesShelter.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;

    public Optional<Photo> savePhoto(MultipartFile file) {
        Photo photo = new Photo();

        try {
            photo.setPhoto(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }

        return Optional.of(photoRepository.save(photo));
    }
}
