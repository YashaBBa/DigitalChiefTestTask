package ru.digitalchief.service;

import ru.digitalchief.dto.UniversityDto;
import ru.digitalchief.model.University;

import java.util.List;

public interface UniversityService {
    List<UniversityDto> getAllUniversity();

    void saveNewUniversity(University university);

    void updateUniversityData(University university);

    University findUniversityById(Integer id);

    void removeUniversity(Integer id);

    boolean existsByName(String name);
}
