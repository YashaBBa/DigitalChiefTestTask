package ru.digitalchief.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.digitalchief.model.Speciality;

import java.util.List;

public interface SpecialityJpaRepo extends JpaRepository<Speciality, Integer> {
    List<Speciality> findAllByFacultyId(Integer id);

}
