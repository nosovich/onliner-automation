package loginTests;

import com.codeborne.selenide.WebDriverRunner;
import driver.BaseTest;
import jdk.jfr.Description;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObject.header.Header;
import pageObject.login.LoginPage;
import patterns.UserBuilder;

public class LoginValidTest extends BaseTest {
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

    @AfterTest
    public void postconditions() {
        WebDriverRunner.closeWebDriver();
    }
}
