package com.Siddharam.UserManagementSystem1.Modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @NotEmpaty(message = "These field cannot be empty ")
    @Size(min =4 ,message = "UserId should have atlest 4 characters")
    private String userId;
    @NotEmpty(message = "These field cannot be empty")
    @Size(min =4,max=12,message = "Username should be in between four to twelve characters ")
    private String userName;


    @Email(message = "Email is not valid")
    private String email;

    @ValidPhoneNumber(message =  "Invalid phone number format.Please enter a 12-digit number with the first two digits as the country code.")
    private String phoneNumber;
    @NotNull(message = "Date of birth must not be null")

    @DateNotValid(message = "Please provide a date in the format YYYY-MM-DD, either for the present day or a valid date ")
    private String dateOfBirth;

    @NotNull(message="These field cannot be empty")
    @DateNotValid(message = "Please provide a date in the format YYYY-MM-DD, either for the present day or a valid date ")
    private String date;

    @NotNull(message = "These field cannot be empty")
    private String time;


}
