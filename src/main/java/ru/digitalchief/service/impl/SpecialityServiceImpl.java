package ru.digitalchief.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.digitalchief.exception.EntityNotFoundException;
import ru.digitalchief.model.Faculty;
import ru.digitalchief.model.Speciality;
import ru.digitalchief.repo.SpecialityJpaRepo;
import ru.digitalchief.service.FacultyService;
import ru.digitalchief.service.SpecialityService;

import javax.persistence.NoResultException;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class SpecialityServiceImpl implements SpecialityService {
    private final SpecialityJpaRepo specialityJpaRepo;
    private final FacultyService facultyService;


    @Value("${exception.message.entityNotFound}")
    private String entityNotFoundMessage;

    @Override
    public List<Speciality> findAllSpecialities() {
        log.debug("Fetching all speciality entities");
        return specialityJpaRepo.findAll();
    }

    @Override
    public String saveNewSpeciality(Speciality speciality, Integer facultyID) {
        log.debug("Saving speciality entity with faculty id {}",facultyID);
        Faculty faculty = facultyService.findFacultyById(facultyID);
        speciality.setFaculty(faculty);
        specialityJpaRepo.save(speciality);
        return String.format("Speciality With name '%s' Was Created!", speciality.getSpecialtyName());
    }

    @Override
    public String updateSpecialityData(Speciality speciality) {
        log.debug("Updating speciality entity with id {}",speciality.getId());
        Speciality oldSpecialityData = findSpecialityById(speciality.getId());
        if (!speciality.getSpecialtyName().isEmpty()) {
            oldSpecialityData.setSpecialtyName(speciality.getSpecialtyName());
        }
        if (!speciality.getDegreeLevel().isEmpty()) {
            oldSpecialityData.setDegreeLevel(oldSpecialityData.getDegreeLevel());
        }
        if (speciality.getMinScore() != null) {
            oldSpecialityData.setMinScore(speciality.getMinScore());
        }
        if (speciality.getFoundingDate() != null) {
            oldSpecialityData.setFoundingDate(speciality.getFoundingDate());
        }
        if (speciality.getCountOfStudents() != null) {
            oldSpecialityData.setCountOfStudents(speciality.getCountOfStudents());
        }
        specialityJpaRepo.save(oldSpecialityData);
        return String.format("Speciality With id=%s Was Updated!", speciality.getId());
    }

    @Override
    public Speciality findSpecialityById(Integer id) {
        log.info("Fetching speciality entity by id {}",id);

            Speciality speciality = specialityJpaRepo.findById(id).orElseThrow(() ->
                    new EntityNotFoundException(String.format(entityNotFoundMessage, id)));
            return speciality;


    }

    @Override
    public String removeSpeciality(Integer id) {
        log.info("Removing speciality entity by id {}",id);
        Speciality speciality = findSpecialityById(id);
        specialityJpaRepo.delete(speciality);
        return String.format("Speciality With id=%s Was Removed!", speciality.getId());
    }

    @Override
    public List<Speciality> findAllSpecialitiesByFacultyId(Integer id) {
        log.debug("Fetching speciality entity with university id {}",id);
        return specialityJpaRepo.findAllByFacultyId(id);
    }


}
