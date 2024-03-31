package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {
    private SelenideElement titleLogin = $$(".title").findBy(Condition.text("Login"));
    private SelenideElement inputEmail = $("[name='email']");
    private SelenideElement inputPass = $("[name='password']");
    private SelenideElement buttonGoOn = $(".button");
    private SelenideElement notification = $(".notification");

    public LoginPage() {
        titleLogin.shouldBe(visible);
    }

    public void inputData (DataHelper.SignUpData signUpData){
        inputEmail.setValue(signUpData.getEmail());
        inputPass.setValue(signUpData.getPassword());
    }

    public ProfilePage clickGoOn (DataHelper.SignUpData signUpData){
        inputData(signUpData);
        buttonGoOn.click();
        return new ProfilePage();
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
    public String getTitle() {
        var text = $(".title").getText();
        return text;
    }



}
