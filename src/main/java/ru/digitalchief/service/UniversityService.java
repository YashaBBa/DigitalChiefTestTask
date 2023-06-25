package ru.digitalchief.service;

import ru.digitalchief.dto.UniversityDto;
import ru.digitalchief.model.University;

import java.util.List;

public interface UniversityService {
    List<UniversityDto> getAllUniversity();

    String saveNewUniversity(University university);

    String updateUniversityData(University university);

    University findUniversityById(Integer id);

    String removeUniversity(Integer id);

    boolean existsByName(String name);
}
