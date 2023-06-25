package ru.digitalchief.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.digitalchief.dto.UniversityDto;
import ru.digitalchief.model.University;
import ru.digitalchief.service.UniversityService;

import java.util.List;

@RestController
@RequestMapping("/api/university")
@RequiredArgsConstructor
@Slf4j
public class UniversityController {
    private final UniversityService universityService;

    @GetMapping("/getAllUniversity")
    public List<UniversityDto> getAllUniversity() {
        log.debug("Fetching all faculty entities");
        return universityService.getAllUniversity();
    }

    @PostMapping("/addNewUniversity")
    public ResponseEntity<String> addNewUniversity(@RequestBody University university) {
        log.debug("Save new university entity");
        String message = universityService.saveNewUniversity(university);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/updateUniversity")
    public ResponseEntity<String> updateUniversity(@RequestBody University university) {
        log.debug("Update new university entity with id {}",university.getId());
        String message = universityService.updateUniversityData(university);
        return ResponseEntity.ok(message);

    }

    @DeleteMapping("/removeUniversityById/{id}")
    public ResponseEntity<String> removeUniversityById(@PathVariable Integer id) {
        log.debug("Remove new university entity with id {}",id);
        String message = universityService.removeUniversity(id);
        return ResponseEntity.ok(message);
    }
}
