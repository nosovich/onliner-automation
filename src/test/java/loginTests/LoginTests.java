package loginTests;

import com.codeborne.selenide.WebDriverRunner;
import driver.BaseTest;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.header.Header;
import pageObject.login.LoginPage;
import patterns.UserBuilder;

public class LoginTests extends BaseTest {
    UserBuilder user;

    @Description("Login verification with valid data")
    @Test(priority = 1)
    public void ValidLogin_Test() {
        user = UserBuilder.builder()
                .email("qa07group@mail.ru")
                .password("pswrd12345")
                .build();
        get(Header.class)
                .goToLoginPage();
        get(LoginPage.class)
                .enterEmail(user)
                .enterPassword(user)
                .clickLoginBtn()
                .clickCheckBox();
        get(Header.class)
                .verifyHeader();
    }

    @Description("Login verification with incorrect data entered")
    @Parameters({"email", "password", "errorText"})
    @Test(priority = 2)
    public void LoginNegative_Test(String email, String password, String error) {
        user = UserBuilder.builder()
                .email(email)
                .password(password)
                .build();
        get(Header.class)
                .goToLoginPage();
        get(LoginPage.class)
                .enterEmail(user)
                .enterPassword(user)
                .clickLoginBtn()
                .checkErrorText(error);
    }

    @AfterMethod
    public void postconditions() {
        WebDriverRunner.closeWebDriver();
    }

}
