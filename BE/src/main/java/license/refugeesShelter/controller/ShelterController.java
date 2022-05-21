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

@RestController
@RequestMapping("shelters")
@RequiredArgsConstructor
public class ShelterController {

    private final ShelterRepository shelterRepository;

    private final ShelterTranslator shelterTranslator;

    private final ShelterService shelterService;

    @GetMapping
    public ResponseEntity<List<ShelterDto>> getAllShelters() {
        return ResponseEntity.ok(shelterTranslator.generateShelterDtoList(shelterRepository.findAll()));
    }

    @GetMapping("/filtered")
    public ResponseEntity<List<ShelterDto>> getSheltersFiltered(FilterShelterDto filterShelterDto) {
        return ResponseEntity.ok(shelterTranslator.generateShelterDtoList(shelterService.getSheltersFiltered(filterShelterDto)));
    }

    @GetMapping("/{shelterId}")
    public ResponseEntity<ShelterDto> getShelter(@PathVariable("shelterId") Long shelterId) {
        return shelterService.findShelter(shelterId)
                .map(shelterTranslator::generateShelterDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    @PostMapping("")
    public ResponseEntity<ShelterDto> addShelter(@RequestBody ShelterDto shelterDto) {
        return shelterService.addNewShelter(shelterDto)
                .map(shelterTranslator::generateShelterDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @PostMapping(value = "/{shelterId}/upload-photo", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> uploadPhoto(@PathVariable("shelterId") Long shelterId, @RequestPart MultipartFile photo) {
        if (shelterService.uploadPhoto(shelterId, photo)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }

    @PutMapping("/{shelterId}")
    public ResponseEntity<ShelterDto> editShelter(@RequestBody ShelterDto shelterDto) {
        return shelterService.editShelter(shelterDto)
                .map(shelterTranslator::generateShelterDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
}
