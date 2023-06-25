package ru.digitalchief.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.digitalchief.model.Faculty;

import javax.persistence.Column;
import java.sql.Date;

@Data
@AllArgsConstructor
public class FacultyDto {
    private Integer id;


    private String facultyName;


    private Date foundingDate;


    private Integer minScore;


    private Integer countOfStudents;


    private String deanName;

    public FacultyDto(Faculty faculty) {
        this.id = faculty.getId();
        this.facultyName = faculty.getFacultyName();
        this.foundingDate = faculty.getFoundingDate();
        this.minScore = faculty.getMinScore();
        this.countOfStudents = faculty.getCountOfStudents();
        this.deanName = faculty.getDeanName();
    }
}
