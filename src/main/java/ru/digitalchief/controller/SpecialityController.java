package ru.digitalchief.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.digitalchief.model.Speciality;
import ru.digitalchief.service.SpecialityService;

import java.util.List;

@RestController
@RequestMapping("/api/speciality")
@RequiredArgsConstructor
@Slf4j
public class SpecialityController {
    private final SpecialityService specialityService;

    @GetMapping("/getAllSpeciality")
    public List<Speciality> getAllSpecialities() {
        log.debug("Fetching all speciality entities");
        return specialityService.findAllSpecialities();
    }

    @GetMapping("/getAllByUniversityId/{id}")
    public List<Speciality> findAllSpecialitiesByFacultyId(@PathVariable Integer id) {
        log.debug("Fetching all faculty entities with faculty id {}",id);
        return specialityService.findAllSpecialitiesByFacultyId(id);
    }

    @PostMapping("/addNewSpeciality/{facultyId}")
    public ResponseEntity<String> addNewSpeciality(@RequestBody Speciality speciality, @PathVariable Integer facultyId) {
        log.debug("Save new speciality entity");
        String message = specialityService.saveNewSpeciality(speciality, facultyId);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/updateSpeciality")
    public ResponseEntity<String> updateFaculty(@RequestBody Speciality speciality) {
        log.debug("Update speciality entity with id {}",speciality.getId());
        String message = specialityService.updateSpecialityData(speciality);
        return ResponseEntity.ok(message);

    }

    @DeleteMapping("/removeSpecialityById/{id}")
    public ResponseEntity<String> removeFacultyById(@PathVariable Integer id) {
        log.debug("Remove speciality entity with id {}",id);
        String message = specialityService.removeSpeciality(id);
        return ResponseEntity.ok(message);
    }
}
