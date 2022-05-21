package license.refugeesShelter.translator;

import license.refugeesShelter.domain.Photo;
import license.refugeesShelter.domain.dto.PhotoDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PhotoTranslator {

    public PhotoDto generatePhotoDto(Photo photo) {
        if (Objects.isNull(photo)) {
            return null;
        }

        PhotoDto photoDto = new PhotoDto();

        photoDto.setPhotoId(photo.getPhotoId());
        photoDto.setPhoto(photo.getPhoto());

        return photoDto;
    }
}
