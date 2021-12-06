import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationForm {
    @Test
    void fillFormTest(){
        open("https://demoqa.com/automation-practice-form");
        //$(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("[id=firstName]").setValue("Yana");
        $("#lastName").setValue("Veryutina");
        $("#userEmail").setValue("test@test.com");
        $("[for=gender-radio-2]").click();
        //$("#genterWrapper").$(byText("Male")).click(); сработал первый вариант
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        //Перед вводом даты нужно очистить поле?
        //$("#dateOfBirthInput").setValue("06 Jan 1997");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__day--006:not(.react-datepicker__day--outside-month)").click();

        //$("#subjectsContainer").click();
        $("#subjectsInput").setValue("Automation").pressEnter();
        $("[for=hobbies-checkbox-3]").click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/img/123456.png"));
        $("#uploadPicture").uploadFromClasspath("img/123456.png");

        $("#currentAddress").setValue("Something");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).scrollTo().click();


        $("#submit").scrollTo().click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Yana Veryutina"), text("test@test.com"));
        $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave(text("Yana Veryutina"));


    }
}
