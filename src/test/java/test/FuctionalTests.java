package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FuctionalTests {

    @BeforeEach
    void setup() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:5000/signup");
    }

    @Test
    void registrationAllInput() {
        var singUpPage = new SignUpPage();
        var signUpData = DataHelper.getUser();
        var newSignUp = new DataHelper.SignUpData(signUpData.getEmail(), signUpData.getName(),
                signUpData.getPassword());
        singUpPage.clickGoOn(newSignUp);
    }
    @Test
    void registrationOnlyMust() {
        var singUpPage = new SignUpPage();
        var signUpData = DataHelper.getUser();
        var newSignUp = new DataHelper.SignUpData(signUpData.getEmail(), "",
                signUpData.getPassword());
        singUpPage.clickGoOn(newSignUp);
    }

    @Test
    void authorization() {
        var singUpPage = new SignUpPage();
        var signUpData = DataHelper.getUser();
        var newSignUp = new DataHelper.SignUpData(signUpData.getEmail(), "",
                signUpData.getPassword());
        var loginPage = singUpPage.clickGoOn(newSignUp);
        var profilePage = loginPage.clickGoOn(newSignUp);

        var expected = "Welcome, "+ newSignUp.getName() + "!";
        var actual = profilePage.getTitle();

        assertEquals(expected, actual);

        var navBar = new NavBar();
        navBar.getLogout();
    }
    @Test
    void registrationWithOldName() {
        var singUpPage = new SignUpPage();
        var signUpData = DataHelper.getUser();
        var newSignUp = new DataHelper.SignUpData(signUpData.getEmail(), signUpData.getName(),
                signUpData.getPassword());
        singUpPage.clickGoOn(newSignUp);
        var navBar = new NavBar();
        navBar.getSignUpPage();

        var anotherSignUpData = DataHelper.getUser();
        var anotherSignUp = new DataHelper.SignUpData(anotherSignUpData.getEmail(), signUpData.getName(),
                anotherSignUpData.getPassword());

        singUpPage.clickGoOn(anotherSignUpData);
    }
}
