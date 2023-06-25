package ru.digitalchief.service;

import ru.digitalchief.dto.FacultyDto;
import ru.digitalchief.model.Faculty;

import java.util.List;

public interface FacultyService {
    public List<FacultyDto> findAllFaculties();


    public String saveNewFaculty(Faculty faculty, Integer id);

    public String updateFacultyData(Faculty faculty);

    public Faculty findFacultyById(Integer id);

    public String removeFaculty(Integer id);

    public List<Faculty> findAllFacultiesByUniversityId(Integer id);
}
