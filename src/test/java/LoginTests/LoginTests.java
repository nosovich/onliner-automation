package LoginTests;

import patterns.UserBuilder;
import driver.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.Header.Header;
import pageObject.Login.LoginPage;

public class LoginTests extends BaseTest {
    UserBuilder user;

    @BeforeTest
    public void preconditions() {
        user = UserBuilder.builder()
                .email("qa07group@mail.ru")
                .password("pswrd12345")
                .build();
    }

    @Test(priority = 1)
    public void ValidLogin_Test() {
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
}
