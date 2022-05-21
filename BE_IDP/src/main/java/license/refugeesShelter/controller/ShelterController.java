package license.refugeesShelter.controller;

import license.refugeesShelter.domain.dto.FilterShelterDto;
import license.refugeesShelter.domain.dto.ShelterDto;
import license.refugeesShelter.repository.ShelterRepository;
import license.refugeesShelter.service.ShelterService;
import license.refugeesShelter.translator.ShelterTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("shelters")
@RequiredArgsConstructor
public class ShelterController {

    private final ShelterRepository shelterRepository;

    private final ShelterTranslator shelterTranslator;

    private final ShelterService shelterService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<ShelterDto>> getAllShelters() {
        return ResponseEntity.ok(shelterTranslator.generateShelterDtoList(shelterRepository.findAll()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/filtered")
    public ResponseEntity<List<ShelterDto>> getSheltersFiltered(FilterShelterDto filterShelterDto) {
        return ResponseEntity.ok(shelterTranslator.generateShelterDtoList(shelterService.getSheltersFiltered(filterShelterDto)));
    }

    @PostMapping(value = "/{shelterId}/upload-photo", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> uploadPhoto(@PathVariable("shelterId") Long shelterId, @RequestPart MultipartFile photo) {
        if (shelterService.uploadPhoto(shelterId, photo)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }
}
