package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage {
    public SelenideElement title = $(".title");

    public String getTitle() {
        var text = $(".title").getText();
        return text;
    }
}
