package ru.digitalchief.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.digitalchief.dto.UniversityDto;
import ru.digitalchief.exception.EntityAlreadyExistsException;
import ru.digitalchief.exception.EntityNotFoundException;
import ru.digitalchief.model.University;
import ru.digitalchief.repo.UniversityJPARepo;
import ru.digitalchief.service.UniversityService;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class UniversityServiceImpl implements UniversityService {
    private final UniversityJPARepo universityJPARepo;

    @Value("${exception.message.entityAlreadyExists}")
    private String entityAlreadyExistsMessage;
    @Value("${exception.message.entityNotFound}")
    private String entityNotFoundMessage;

    @Override
    public List<UniversityDto> getAllUniversity() {
        log.debug("Fetching all university entities");
        List<UniversityDto> universities = universityJPARepo.findBy();

        return universities;
    }

    @Override
    public String saveNewUniversity(University university) {
        //if university not exists
        // will be equals true
        boolean isExists = existsByName(university.getUniversityName());
        if (isExists) {
            log.debug("Saving university entity");
            universityJPARepo.save(university);

        }
        return String.format("University With name '%s' Was Created!", university.getUniversityName());

    }

    @Override
    public String updateUniversityData(University university) {
        log.debug("Updating university entity with id {}", university.getId());
        University oldVersionOfUniversity = findUniversityById(university.getId());

        if (!university.getCityName().isEmpty()) {
            oldVersionOfUniversity.setCityName(university.getCityName());
        }
        if (!university.getCountryName().isEmpty()) {
            oldVersionOfUniversity.setCountryName(university.getCountryName());
        }
        if (university.getNumberOfStudents() != null) {
            oldVersionOfUniversity.setNumberOfStudents(university.getNumberOfStudents());
        }
        if (university.getFoundingDate() != null) {
            oldVersionOfUniversity.setFoundingDate(university.getFoundingDate());
        }
        if (!university.getUniversityName().isEmpty()) {
            oldVersionOfUniversity.setUniversityName(university.getUniversityName());
        }
        universityJPARepo.save(oldVersionOfUniversity);
        return String.format("University With id=%s Was Updated!", university.getId());
    }

    @Override
    public University findUniversityById(Integer id) {
        log.debug("Fetching university entity with id {}", id);

        University university = universityJPARepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format(entityNotFoundMessage, id)));
        return university;


    }

    @Override
    public String removeUniversity(Integer id) {
        log.debug("Removing university entity with id {}", id);
        University university = findUniversityById(id);
        universityJPARepo.delete(university);
        return String.format("University with id=%s was removed!", id);
    }

    @Override
    public boolean existsByName(String name) {
        log.debug("Checking if university with name {} exists", name);
        List<University> universities = universityJPARepo.findByUniversityName(name);
        if (universities.isEmpty()) {
            return true;
        } else {
            log.info("University with name {} already exist", name);
            throw new EntityAlreadyExistsException(String.format(entityAlreadyExistsMessage, name));
        }

    }
}
