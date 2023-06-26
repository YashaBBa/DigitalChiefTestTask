package ru.digitalchief.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.digitalchief.model.University;

import java.sql.Date;

@Data
@AllArgsConstructor
public class UniversityDto {
    private Integer id;
    private String universityName;
    private String countryName;
    private String cityName;
    private Date foundingDate;
    private Integer numberOfStudents;

    public UniversityDto(University entity) {
        this.id = entity.getId();
        this.universityName = entity.getUniversityName();
        this.countryName = entity.getCountryName();
        this.cityName = entity.getCityName();
        this.foundingDate = entity.getFoundingDate();
        this.numberOfStudents = entity.getNumberOfStudents();
    }
}
