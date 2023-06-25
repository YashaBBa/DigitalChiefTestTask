package ru.digitalchief.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "university")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String universityName;

    @Column(name = "country")
    private String countryName;

    @Column(name = "city")
    private String cityName;

    @Column(name = "founding_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date foundingDate;

    @Column(name = "numberOfStudents")
    private Integer numberOfStudents;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "university")
    private List<Faculty> facultyList;


}
