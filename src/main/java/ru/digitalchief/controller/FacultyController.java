package ru.digitalchief.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.digitalchief.dto.FacultyDto;
import ru.digitalchief.model.Faculty;
import ru.digitalchief.model.Speciality;
import ru.digitalchief.service.FacultyService;
import ru.digitalchief.service.SpecialityService;

import java.util.List;

@RestController
@RequestMapping("/api/faculties")
@RequiredArgsConstructor
@Slf4j
public class FacultyController {

    private final FacultyService facultyService;
    private final SpecialityService specialityService;

    @GetMapping
    public List<FacultyDto> getAllFaculties() {
        log.debug("Fetching all faculties");
        return facultyService.findAllFaculties();
    }

    @GetMapping("/{id}/specialities")
    public List<Speciality> findAllSpecialitiesByFacultyId(@PathVariable Integer id) {
        log.debug("Fetching all faculty entities with faculty id {}", id);
        return specialityService.findAllSpecialitiesByFacultyId(id);
    }


    @PostMapping("/{facultyId}/specialities")
    public ResponseEntity<String> addNewSpeciality(@RequestBody Speciality speciality, @PathVariable Integer facultyId) {
        log.debug("Save new speciality entity");
        specialityService.saveNewSpeciality(speciality, facultyId);
        return ResponseEntity.ok(String.format("Speciality With name '%s' Was Created!", speciality.getSpecialtyName()));
    }


    @PutMapping
    public ResponseEntity<String> updateFaculty(@RequestBody Faculty faculty) {
        log.debug("Update faulty entity with id {}", faculty.getId());
        facultyService.updateFacultyData(faculty);
        return ResponseEntity.ok(String.format("Faculty With id=%s Was Updated!", faculty.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeFacultyById(@PathVariable Integer id) {
        log.debug("Remove faulty entity with id {}", id);
        facultyService.removeFaculty(id);
        return ResponseEntity.ok(String.format("Faculty with id=%s was removed!", id));
    }


}
