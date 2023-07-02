package com.Siddharam.UserManagementSystem1.Customvalidationimpl;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {



        if (phoneNumber.length() != 12) {
            return false;
        }


        String countryCode = phoneNumber.substring(0, 2);
        if (!countryCode.matches("[0-9]+")) {
            return false;
        }


        String restOfNumber = phoneNumber.substring(2);
        if (!restOfNumber.matches("[0-9]+")) {
            return false;
        }

        return true;
    }

}
