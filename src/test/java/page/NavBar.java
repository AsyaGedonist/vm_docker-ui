package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class NavBar {
    private ElementsCollection navbar = Selenide.$$(".navbar-item");
    private SelenideElement homeNavbar = navbar.findBy(Condition.text("Home"));
    private SelenideElement loginNavbar = navbar.findBy(Condition.text("Login"));
    private SelenideElement signUpNavbar = navbar.findBy(Condition.text("Sign Up"));
    private SelenideElement logoutNavbar = navbar.findBy(Condition.text("Logout"));

    public SignUpPage getSignUpPage(){
        signUpNavbar.click();
        return new SignUpPage();
    }

    public LoginPage getLoginPage(){
        loginNavbar.click();
        return new LoginPage();
    }

    public HomePage getHomePage(){
        homeNavbar.click();
        return new HomePage();
    }

    public HomePage getLogout(){
        logoutNavbar.click();
        return new HomePage();
    }
}
