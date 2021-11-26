package loginTests;

import com.codeborne.selenide.WebDriverRunner;
import driver.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.header.Header;
import pageObject.login.LoginPage;
import patterns.UserBuilder;
import testngConfig.Retry;

public class LoginNegativeTests extends BaseTest {
    UserBuilder user;

    @Description("Login verification with incorrect data entered")
    @Parameters({"email", "password", "errorText"})
    @Test(retryAnalyzer = Retry.class)
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
