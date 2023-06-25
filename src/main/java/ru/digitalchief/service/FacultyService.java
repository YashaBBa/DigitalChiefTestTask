package ru.digitalchief.service;

import ru.digitalchief.dto.FacultyDto;
import ru.digitalchief.model.Faculty;

import java.util.List;

public interface FacultyService {
    List<FacultyDto> findAllFaculties();


    String saveNewFaculty(Faculty faculty, Integer id);

    String updateFacultyData(Faculty faculty);

    Faculty findFacultyById(Integer id);

    String removeFaculty(Integer id);

    List<Faculty> findAllFacultiesByUniversityId(Integer id);
}
