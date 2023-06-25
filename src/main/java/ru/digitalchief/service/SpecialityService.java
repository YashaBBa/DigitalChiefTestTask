package ru.digitalchief.service;

import ru.digitalchief.model.Speciality;

import java.util.List;

public interface SpecialityService {
    public List<Speciality> findAllSpecialities();


    public String saveNewSpeciality(Speciality speciality, Integer specialityId);

    public String updateSpecialityData(Speciality speciality);

    public Speciality findSpecialityById(Integer id);

    public String removeSpeciality(Integer id);

    public List<Speciality> findAllSpecialitiesByFacultyId(Integer id);
}
