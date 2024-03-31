package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.HomePage;
import page.NavBar;

import static com.codeborne.selenide.Selenide.open;

public class AvailabilityTests {

    @BeforeEach
    void setup() {
//        Configuration.holdBrowserOpen = true;
        open("http://localhost:5000");
    }

    @Test
    void availabilityHomePage() {
        var homePage = new HomePage();
    }

    @Test
    void availabilitySignUpPage() {
        var navBar = new NavBar();
        var signUpPage = navBar.getSignUpPage();
    }

    @Test
    void availabilityLoginPage() {
        var navBar = new NavBar();
        var loginPage = navBar.getLoginPage();
    }
}
