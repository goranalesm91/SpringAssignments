package com.siddharam.JobSearchPortal.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.intellij.lang.annotations.Pattern;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Portal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    private String description;

    private String location;

    @Min(value = 20000, message = "Salary should be above 20,000")
    private Double salary;

    @Email
    private String companyEmail;

    private String companyName;

    private String employerName;

    @Enumerated(EnumType.STRING)
    private Type jobType;

    private LocalDate appliedDate;
}
