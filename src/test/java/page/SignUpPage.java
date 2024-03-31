package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import javax.lang.model.element.Name;

import java.lang.reflect.Type;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SignUpPage {

    private SelenideElement inputEmail = $("[name='email']");
    private SelenideElement inputName = $("[name='name']");
    private SelenideElement inputPass = $("[name='password']");

    private SelenideElement buttonGoOn = $(".button");
    private SelenideElement titleSignUp = $$(".title").findBy(Condition.text("Sign Up"));
    private SelenideElement notification = $(".notification");

    public SignUpPage() {
        titleSignUp.shouldBe(visible);
    }

    public String getTitle() {
        var text = $(".title").getText();
        return text;
    }

    public void inputData (DataHelper.SignUpData signUpData){
        inputEmail.setValue(signUpData.getEmail());
        inputName.setValue(signUpData.getName());
        inputPass.setValue(signUpData.getPassword());
    }

    public LoginPage clickGoOn (DataHelper.SignUpData signUpData){
        inputData(signUpData);
        buttonGoOn.click();
        return new LoginPage();
    }

    public void clickButton (){
        buttonGoOn.click();
    }

    public void showNotification (DataHelper.SignUpData signUpData, String expected){
        inputData(signUpData);
        clickButton();
        notification.shouldHave(text(expected));
        notification.shouldBe(Condition.visible);
    }

    public void showNotificationAlert (DataHelper.SignUpData signUpData){
        inputData(signUpData);
        clickButton();
        $(withText("Адрес электронной почты должен содержать символ"))
                .shouldBe(visible);
    }
}
