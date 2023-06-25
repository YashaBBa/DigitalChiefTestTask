package ru.digitalchief.service;

import ru.digitalchief.dto.UniversityDto;
import ru.digitalchief.model.University;

import java.util.List;

public interface UniversityService {
    public List<UniversityDto> getAllUniversity();

    public String saveNewUniversity(University university);

    public String updateUniversityData(University university);

    public University findUniversityById(Integer id);

    public String removeUniversity(Integer id);

    boolean existsByName(String name);
}
