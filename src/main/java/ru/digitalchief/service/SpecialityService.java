package ru.digitalchief.service;

import ru.digitalchief.model.Speciality;

import java.util.List;

public interface SpecialityService {

    List<Speciality> findAllSpecialities();

    void saveNewSpeciality(Speciality speciality, Integer specialityId);

    void updateSpecialityData(Speciality speciality);

    Speciality findSpecialityById(Integer id);

    void removeSpeciality(Integer id);

    List<Speciality> findAllSpecialitiesByFacultyId(Integer id);
}
