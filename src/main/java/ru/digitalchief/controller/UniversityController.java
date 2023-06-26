package ru.digitalchief.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.digitalchief.dto.UniversityDto;
import ru.digitalchief.model.Faculty;
import ru.digitalchief.model.University;
import ru.digitalchief.service.FacultyService;
import ru.digitalchief.service.UniversityService;

import java.util.List;

@RestController
@RequestMapping("/api/universities")
@RequiredArgsConstructor
@Slf4j
public class UniversityController {
    private final UniversityService universityService;
    private final FacultyService facultyService;

    @GetMapping
    public List<UniversityDto> getAllUniversity() {
        log.debug("Fetching all faculty entities");
        return universityService.getAllUniversity();
    }

    @PostMapping
    public ResponseEntity<String> addNewUniversity(@RequestBody University university) {
        log.debug("Save new university entity");
        universityService.saveNewUniversity(university);
        return ResponseEntity.ok(String.format("University With name '%s' Was Created!", university.getUniversityName()));
    }

    @PostMapping("/{universityId}/faculties")
    public ResponseEntity<String> addNewFaculty(@RequestBody Faculty faculty, @PathVariable Integer universityId) {
        log.debug("Save new faculty entity");
        facultyService.saveNewFaculty(faculty, universityId);
        return ResponseEntity.ok(String.format("Faculty With name '%s' Was Created!", faculty.getFacultyName()));
    }

    @GetMapping("/{id}/faculties")
    public List<Faculty> findAllFacultiesByUniversityId(@PathVariable Integer id) {
        log.debug("Fetching all faculty entities with university id {}", id);
        return facultyService.findAllFacultiesByUniversityId(id);
    }

    @PutMapping
    public ResponseEntity<String> updateUniversity(@RequestBody University university) {
        log.debug("Update new university entity with id {}", university.getId());
        universityService.updateUniversityData(university);
        return ResponseEntity.ok(String.format("University With id=%s Was Updated!", university.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeUniversityById(@PathVariable Integer id) {
        log.debug("Remove new university entity with id {}", id);
        universityService.removeUniversity(id);
        return ResponseEntity.ok(String.format("University with id=%s was removed!", id));
    }
}
