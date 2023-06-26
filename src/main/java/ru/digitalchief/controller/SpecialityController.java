package ru.digitalchief.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.digitalchief.model.Speciality;
import ru.digitalchief.service.SpecialityService;

import java.util.List;

@RestController
@RequestMapping("/api/specialities")
@RequiredArgsConstructor
@Slf4j
public class SpecialityController {
    private final SpecialityService specialityService;

    @GetMapping
    public List<Speciality> getAllSpecialities() {
        log.debug("Fetching all speciality entities");
        return specialityService.findAllSpecialities();
    }

    @PutMapping
    public ResponseEntity<String> updateFaculty(@RequestBody Speciality speciality) {
        log.debug("Update speciality entity with id {}", speciality.getId());
        specialityService.updateSpecialityData(speciality);
        return ResponseEntity.ok(String.format("Speciality With id=%s Was Updated!", speciality.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeFacultyById(@PathVariable Integer id) {
        log.debug("Remove speciality entity with id {}", id);
        specialityService.removeSpeciality(id);
        return ResponseEntity.ok(String.format("Speciality With id=%s Was Removed!", id));
    }
}
