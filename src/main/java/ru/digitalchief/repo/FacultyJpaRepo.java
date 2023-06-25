package ru.digitalchief.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.digitalchief.dto.FacultyDto;
import ru.digitalchief.model.Faculty;

import java.util.List;

@Repository
public interface FacultyJpaRepo extends JpaRepository<Faculty, Integer> {
    List<Faculty> findByUniversityId(Integer id);

    @Query("SELECT new ru.digitalchief.dto.FacultyDto(f) from Faculty f")
    List<FacultyDto> findBy();
}
