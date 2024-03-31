package test;

import com.codeborne.selenide.Configuration;
import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.NavBar;
import page.SignUpPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegativeFunctionalTests {
    @BeforeEach
    void setup() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:5000/signup");
    }

    @Test
    void noDataSignUp(){
        var singUpPage = new SignUpPage();
        var newSignUp = new DataHelper.SignUpData("","", "");
        singUpPage.showNotification(newSignUp, "Fill email and password fields!");
        assertEquals("Sign Up", singUpPage.getTitle());
    }

    @Test
    void oldDataSignUp(){
        var singUpPage = new SignUpPage();
        var signUpData = DataHelper.getUser();
        var newSignUp = new DataHelper.SignUpData(signUpData.getEmail(), signUpData.getName(),
                signUpData.getPassword());
        singUpPage.clickGoOn(newSignUp);

        var navBar = new NavBar();
        navBar.getSignUpPage();
        singUpPage.showNotification(newSignUp, "Email address already exists.");
    }
    @Test
    void failDataLogin(){
        var navBar = new NavBar();
        var loginPage = navBar.getLoginPage();
        var signUpData = DataHelper.getUser();
        var newSignUp = new DataHelper.SignUpData(signUpData.getEmail(), signUpData.getName(),
                signUpData.getPassword());
        loginPage.showNotification(newSignUp, "Please check your login details and try again.");
        assertEquals("Login", loginPage.getTitle());
    }
    @Test
    void loginWithWrongPassword() {
        var singUpPage = new SignUpPage();
        var signUpData = DataHelper.getUser();
        var newSignUp = new DataHelper.SignUpData(signUpData.getEmail(), signUpData.getName(),
                signUpData.getPassword());
        var anotherSignUpData = DataHelper.getUser();
        var anotherPassSignUp = new DataHelper.SignUpData(signUpData.getEmail(), signUpData.getName(),
                anotherSignUpData.getPassword());

        var loginPage = singUpPage.clickGoOn(newSignUp);
        loginPage.showNotification(anotherPassSignUp, "Please check your login details and try again.");
        assertEquals("Login", loginPage.getTitle());
    }
    @Test
    void loginWithWrongEmail() {
        var singUpPage = new SignUpPage();
        var signUpData = DataHelper.getUser();
        var newSignUp = new DataHelper.SignUpData(signUpData.getEmail(), signUpData.getName(),
                "qwerty123");
        var anotherPassSignUp = new DataHelper.SignUpData(signUpData.getEmail(), signUpData.getName(),
                "QWERTY123");

        var loginPage = singUpPage.clickGoOn(newSignUp);
        loginPage.showNotification(anotherPassSignUp, "Please check your login details and try again.");
        assertEquals("Login", loginPage.getTitle());
    }
}
