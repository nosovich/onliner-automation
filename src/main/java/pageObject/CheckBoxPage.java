package pageObject;

import com.codeborne.selenide.SelenideElement;
import driver.BaseTest;
import pageObject.Login.LoginPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckBoxPage extends BaseTest {

    SelenideElement checkbox = $(".recaptcha-checkbox-border");


    public CheckBoxPage clickCheckBox() {
        checkbox.shouldBe(visible).click();
        return this;
    }

}
