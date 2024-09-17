package tests;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;

public class AutomationPracticeFormWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationWithFullDataTest() {
        String firstName = "Anna";
        String lastName = "Karenina";
        String userEmail = "anna@karenina.com";
        String gender = "Female";
        String phoneNumber = "9031112233";
        String[] dateOfBirth  = new String[] {"31", "July", "1991"};
        String[] subjects = new String[] {"Maths", "Computer Science"};
        String[] hobbies = new String[] {"Reading", "Music"};
        String picName = "ava.png";
        String currentAddress = "Moscow, Russia";
        String state = "Haryana";
        String city = "Panipat";

        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDateOfBirth(dateOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth",dateOfBirth[0] + " " + dateOfBirth[1] + "," + dateOfBirth[2])
                .checkResult("Subjects", subjects[0] + ", " + subjects[1])
                .checkResult("Hobbies", hobbies[0] + ", " + hobbies[1])
                .checkResult("Picture", picName)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void successfulRegistrationWithOnlyRequiredFieldsTest() {
        String firstName = "Anna";
        String lastName = "Karenina";
        String gender = "Female";
        String phoneNumber = "9031112233";

        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .clickSubmit();

        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber);
    }

    @Test
    void negativeRegistrationTest() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.openPage().clickSubmit();

        registrationPage.negativeCheck();
    }
}