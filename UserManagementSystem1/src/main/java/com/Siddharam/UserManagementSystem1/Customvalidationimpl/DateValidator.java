package com.Siddharam.UserManagementSystem1.Customvalidationimpl;


import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;


public class DateValidator  implements ConstraintValidator<DateNotValid, String>{


    @Override
    public void initialize(DateNotValid constraintAnnotation) {
    }




    @Override
    public boolean isValid(String date, ConstraintValidatorContext context) {


        String strDate = date.toString();

        if(strDate.length() != 10) {
            return false;
        }
        if(strDate.charAt(4) != '-' || strDate.charAt(7) != '-') {
            return false;
        }

        String year = strDate.substring(0, 4);
        int yearInInt;
        try {
            yearInInt = Integer.parseInt(year);
        } catch (NumberFormatException e) {
            return false;
        }

        if (!year.matches("[0-9]+")) {
            return false;
        }

        String month = strDate.substring(5, 7);
        int monthInInt;
        try {
            monthInInt = Integer.parseInt(month);
        } catch (NumberFormatException e) {
            return false;
        }

        if (!month.matches("[0-9]+")) {
            return false;
        }

        if(monthInInt <= 0 || monthInInt > 12) {
            return false;
        }

        String monthDate = strDate.substring(8, 10);
        int monthDateInInt;
        try {
            monthDateInInt = Integer.parseInt(monthDate);
        } catch (NumberFormatException e) {
            return false;
        }

        if (!monthDate.matches("[0-9]+")) {
            return false;
        }

        if(monthDateInInt > 31 || monthDateInInt <= 0) {
            return false;
        }

        if(yearInInt % 4 == 0 && monthInInt == 2 && monthDateInInt > 28) {
            return false;
        }
        if(monthInInt == 2 && monthDateInInt > 27&&yearInInt % 4 != 0 ) {
            return false;
        }
        if((monthInInt == 4 || monthInInt == 6 || monthInInt == 9 || monthInInt == 11) && monthDateInInt > 30) {
            return false;
        }
        LocalDate today = LocalDate.now();
        String todayDate=today.toString();
        String todayYear=todayDate.substring(0, 4);
        int todayYearInInt=Integer.parseInt(todayYear);
        String todayMonth=todayDate.substring(5, 7);
        int todayMonthInInt=Integer.parseInt(todayMonth);
        String todayMonthDate=todayDate.substring(8, 10);
        int todayMonthDateInInt=Integer.parseInt(todayMonthDate);

        if( yearInInt>todayYearInInt) {

            return false;
        }
        if( yearInInt==todayYearInInt&&monthInInt>todayMonthInInt) {
            return false;


        }
        if( yearInInt==todayYearInInt&&monthInInt==todayMonthInInt&&monthDateInInt>todayMonthDateInInt) {
            return false;
        }






        return true;
    }}














