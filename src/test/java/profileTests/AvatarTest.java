package profileTests;

import driver.BaseTest;
import jdk.jfr.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.header.Header;
import pageObject.login.LoginPage;
import pageObject.profilePage.ProfilePage;
import patterns.UserBuilder;

public class AvatarTest extends BaseTest {
    UserBuilder user;

    @BeforeTest
    public void preconditions() {
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
    }

    @Description("Upload profile avatar")
    @Test
    public void uploadProfileAvatar_Test() {
        get(Header.class)
                .verifyHeader()
                .goToProfile();
        get(ProfilePage.class)
                .uploadAvatar()
                .checkUploadedAvatar();
    }
}
