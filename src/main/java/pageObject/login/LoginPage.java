package pageObject.login;

import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;
import patterns.UserBuilder;
import com.codeborne.selenide.SelenideElement;
import pageObject.base.BasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    SelenideElement email = $("[class^='auth-input auth-input_primary']");
    SelenideElement password = $("input[type='password']");
    SelenideElement loginBtn = $("button[class^='auth-button']");
    SelenideElement errorText = $("div[class*='description_error']");
    SelenideElement captchaContainer = $("#captcha-guard");
    SelenideElement captcha = $("[title='reCAPTCHA']");
    SelenideElement checkbox = $(By.xpath("//span[@id='recaptcha-anchor']"));

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

    // When entering the login and password, a captcha may appear on the login page, where it is necessary to confirm that the user is not a robot.
    // If captcha does not appear - test passed. If only one captcha appeared - test passed. If additional captcha appears - test failed.
    public LoginPage closeCaptcha() {
        SelenideElement visibleElement = null;
        try {
            visibleElement = captchaContainer.should(visible);
        } catch(ElementNotFound e) {
            System.out.println("Капчу не показали. Вам повезло");
        }
        if (visibleElement != null) {
            switchTo().frame(captcha);
            checkbox.click();
        }
        return this;
    }

    public LoginPage checkErrorText(String text) {
        errorText.should(matchText(text));
        return this;
    }
}
