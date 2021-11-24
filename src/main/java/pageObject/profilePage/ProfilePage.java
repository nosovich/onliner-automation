package pageObject.profilePage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import driver.BaseTest;
import org.openqa.selenium.By;
import properties.PropertyReader;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends BaseTest {

    SelenideElement profileAvatar = $("div[class='profile-header__preview']>div");
    SelenideElement uploadAvatar = $("div[class='profile-form__control profile-form__control_condensed-default']>label");
    SelenideElement createdAvatar = $("div[class*='profile-header__image_person'][style*='background-image: url']");
    SelenideElement saveAvatar = $(By.xpath("//a[contains(text(),'Сохранить')]"));
    private String userDir = System.getProperty("user.dir");

    public ProfilePage uploadAvatar() {
        profileAvatar.click();
        uploadAvatar.sendKeys(userDir + PropertyReader.getProperties().getProperty("filePath"));
        saveAvatar.click();
        return this;
    }

    public ProfilePage checkUploadedAvatar() {
        createdAvatar.shouldBe(exist);
        return this;
    }

}
