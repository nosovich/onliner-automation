package loginTests;

import com.codeborne.selenide.WebDriverRunner;
import driver.BaseTest;
import jdk.jfr.Description;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObject.header.Header;
import pageObject.login.LoginPage;
import patterns.UserBuilder;
import testngConfig.Retry;

public class LoginValidTest extends BaseTest {
    UserBuilder user;

    @Description("Login verification with valid data")
    @Test(retryAnalyzer = Retry.class)
    public void ValidLogin_Test() {
        user = UserBuilder.builder()
                .email("v.nos1706@gmail.com")
                .password("pswrd12345")
                .build();
        get(Header.class)
                .goToLoginPage();
        get(LoginPage.class)
                .enterEmail(user)
                .enterPassword(user)
                .clickLoginBtn()
                .closeCaptcha();
        get(Header.class)
                .verifyHeader();
    }

    @AfterTest
    public void postconditions() {
        WebDriverRunner.closeWebDriver();
    }
}
