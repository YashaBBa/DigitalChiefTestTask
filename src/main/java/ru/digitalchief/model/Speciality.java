package ru.digitalchief.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "speciality")
@Data
public class Speciality {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String specialtyName;

    @Column(name = "degree_level")
    private String degreeLevel;

    @Column(name = "min_score")
    private Integer minScore;

    @Column(name = "count_of_students")
    private Integer countOfStudents;

    @Column(name = "founding_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date foundingDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "faculties_id")
    @JsonIgnore
    private Faculty faculty;
}
