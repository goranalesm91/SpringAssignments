package com.siddharam.JobSearchPortal.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.intellij.lang.annotations.Pattern;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Portal {
    @Id
    private Integer id;
    private String title;
    private String description;
    private String location;
    @Min(value = 20000)
   // @Max(value = 200_000)
    private Double salary;
    private String companyEmail;
    private String companyName;
    private String employerName;
    private Type jobType;
}
