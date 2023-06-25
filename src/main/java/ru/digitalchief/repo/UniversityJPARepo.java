package ru.digitalchief.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.digitalchief.dto.UniversityDto;
import ru.digitalchief.model.University;

import java.util.List;
import java.util.Optional;

@Repository
public interface UniversityJPARepo extends JpaRepository<University, Integer> {
    Optional<University> findById(Integer id);

    @Query("SELECT new ru.digitalchief.dto.UniversityDto(u) from University u")
    List<UniversityDto> findBy();

    List<University> findByUniversityName(String name);


}
