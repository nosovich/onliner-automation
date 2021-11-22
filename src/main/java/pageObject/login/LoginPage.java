package pageObject.login;

import com.codeborne.selenide.Selenide;
import patterns.UserBuilder;
import com.codeborne.selenide.SelenideElement;
import pageObject.BasePage;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    SelenideElement email = $("[class^='auth-input auth-input_primary']");
    SelenideElement password = $("input[type='password']");
    SelenideElement loginBtn = $("button[class^='auth-button']");
    SelenideElement errorText = $("div[class*='description_error']");
    SelenideElement checkbox = $(".recaptcha-checkbox-border");

    public LoginPage enterEmail(UserBuilder user) {
        email.setValue(user.getEmail());
        return this;
    }

    public LoginPage enterPassword(UserBuilder user) {
        password.setValue(user.getPassword());
        return this;
    }

    public LoginPage clickLoginBtn() {
        loginBtn.click();
        return this;
    }

    public LoginPage clickCheckBox() {
        moveToElement(checkbox).click();
        return this;
    }


    public LoginPage checkErrorText(String text) {
        errorText.should(matchText(text));
        return this;
    }
}
