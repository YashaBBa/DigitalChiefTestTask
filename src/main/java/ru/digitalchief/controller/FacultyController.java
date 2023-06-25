package ru.digitalchief.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.digitalchief.dto.FacultyDto;
import ru.digitalchief.model.Faculty;
import ru.digitalchief.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
@RequiredArgsConstructor
@Slf4j
public class FacultyController {
    private final FacultyService facultyService;

    @GetMapping("/getAllFaculties")
    public List<FacultyDto> getAllFaculties() {
        log.debug("Fetching all faculties");
        return facultyService.findAllFaculties();
    }

    @GetMapping("/getAllByUniversityId/{id}")
    public List<Faculty> findAllFacultiesByFacultyId(@PathVariable Integer id) {
        log.debug("Fetching all faculty entities with university id {}", id);
        return facultyService.findAllFacultiesByUniversityId(id);
    }

    @PostMapping("/addNewFaculty/{universityId}")
    public ResponseEntity<String> addNewFaculty(@RequestBody Faculty faculty, @PathVariable Integer universityId) {
        log.debug("Save new faculty entity");
        String message = facultyService.saveNewFaculty(faculty, universityId);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/updateFaculty")
    public ResponseEntity<String> updateFaculty(@RequestBody Faculty faculty) {
        log.debug("Update faulty entity with id {}",faculty.getId());
        String message = facultyService.updateFacultyData(faculty);
        return ResponseEntity.ok(message);

    }

    @DeleteMapping("/removeFacultyById/{id}")
    public ResponseEntity<String> removeFacultyById(@PathVariable Integer id) {
        log.debug("Remove faulty entity with id {}",id);
        String message = facultyService.removeFaculty(id);
        return ResponseEntity.ok(message);
    }


}
