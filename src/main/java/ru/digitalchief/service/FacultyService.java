package ru.digitalchief.service;

import ru.digitalchief.dto.FacultyDto;
import ru.digitalchief.model.Faculty;

import java.util.List;

public interface FacultyService {
    List<FacultyDto> findAllFaculties();

    void saveNewFaculty(Faculty faculty, Integer id);

    void updateFacultyData(Faculty faculty);

    Faculty findFacultyById(Integer id);

    void removeFaculty(Integer id);

    List<Faculty> findAllFacultiesByUniversityId(Integer id);
}
