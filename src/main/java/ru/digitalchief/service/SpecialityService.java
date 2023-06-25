package ru.digitalchief.service;

import ru.digitalchief.model.Speciality;

import java.util.List;

public interface SpecialityService {
    List<Speciality> findAllSpecialities();


    String saveNewSpeciality(Speciality speciality, Integer specialityId);

    String updateSpecialityData(Speciality speciality);

    Speciality findSpecialityById(Integer id);

    String removeSpeciality(Integer id);

    List<Speciality> findAllSpecialitiesByFacultyId(Integer id);
}
