package ru.digitalchief.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "faculty")
@Data
public class Faculty {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String facultyName;

    @Column(name = "founding_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date foundingDate;

    @Column(name = "min_score")
    private Integer minScore;

    @Column(name = "count_of_students")
    private Integer countOfStudents;

    @Column(name = "dean_name")
    private String deanName;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "univers_id")
    @JsonIgnore
    private University university;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "faculty")
    private List<Speciality> specilaityList;


}
