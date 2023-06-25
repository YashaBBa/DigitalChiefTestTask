package ru.digitalchief.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.digitalchief.dto.FacultyDto;
import ru.digitalchief.exception.EntityNotFoundException;
import ru.digitalchief.model.Faculty;
import ru.digitalchief.model.University;
import ru.digitalchief.repo.FacultyJpaRepo;
import ru.digitalchief.service.FacultyService;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class FacultyServiceImpl implements FacultyService {
    private final FacultyJpaRepo facultyJpaRepo;
    private final UniversityServiceImpl universityService;

    @Value("${exception.message.entityAlreadyExists}")
    private String entityAlreadyExistsMessage;
    @Value("${exception.message.entityNotFound}")
    private String entityNotFoundMessage;

    @Override
    public List<FacultyDto> findAllFaculties() {
        log.debug("Fetching all faculty entities");
        return facultyJpaRepo.findBy();
    }

    @Override
    public String saveNewFaculty(Faculty faculty, Integer universityId) {
        log.debug("Saving faculty entity with university id {}", universityId);
        University university = universityService.findUniversityById(universityId);
        faculty.setUniversity(university);
        facultyJpaRepo.save(faculty);
        return String.format("Faculty With name '%s' Was Created!", faculty.getFacultyName());
    }

    @Override
    public String updateFacultyData(Faculty faculty) {
        log.debug("Updating faculty entity with id {}", faculty.getId());
        Faculty oldFacultyData = findFacultyById(faculty.getId());
        if (!faculty.getFacultyName().isEmpty()) {
            oldFacultyData.setFacultyName(faculty.getFacultyName());
        }
        if (faculty.getFoundingDate() != null) {
            oldFacultyData.setFoundingDate(faculty.getFoundingDate());
        }
        if (faculty.getMinScore() != null) {
            oldFacultyData.setMinScore(faculty.getMinScore());
        }
        if (faculty.getCountOfStudents() != null) {
            oldFacultyData.setCountOfStudents(faculty.getCountOfStudents());
        }
        if (!faculty.getDeanName().isEmpty()) {
            oldFacultyData.setDeanName(faculty.getDeanName());
        }
        facultyJpaRepo.save(oldFacultyData);
        return String.format("Faculty With id=%s Was Updated!", faculty.getId());
    }

    @Override
    public Faculty findFacultyById(Integer id) {
        log.info("Fetching faculty entity by id {}", id);

        Faculty faculty = facultyJpaRepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format(entityNotFoundMessage, id)));
        return faculty;

    }

    @Override
    public String removeFaculty(Integer id) {
        log.info("Removing faculty entity by id {}", id);
        Faculty faculty = findFacultyById(id);
        facultyJpaRepo.delete(faculty);
        return String.format("Faculty with id=%s was removed!", id);
    }

    @Override
    public List<Faculty> findAllFacultiesByUniversityId(Integer id) {
        log.debug("Fetching faculty entity with university id {}", id);
        List<Faculty> faculties = facultyJpaRepo.findByUniversityId(id);
        return faculties;
    }
}
