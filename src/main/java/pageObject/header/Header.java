package pageObject.header;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pageObject.base.BasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Header extends BasePage {

    SelenideElement catalogBtn = $("a[href='https://catalog.onliner.by/']");
    SelenideElement onlinerLogo = $(".onliner_logo");
    SelenideElement search = $(".fast-search__form");
    SelenideElement cartIcon = $(".auth-bar.auth-bar--top > a");
    SelenideElement loginBtn = $(By.xpath("//div[contains(@class,'auth-bar--top')]//div[@class='auth-bar__item auth-bar__item--text']"));
    SelenideElement profileBtn = $("div[class='b-top-profile__item b-top-profile__item_arrow']");
    SelenideElement profileName = $("div[class='b-top-profile__name']>a");


    ElementsCollection navigationMenu = $$(By.cssSelector(".b-main-navigation"));

    public Header goToCatalog() {
        catalogBtn.shouldBe(enabled).click();
        return this;
    }

    public Header goToLoginPage() {
        pause(3);
        loginBtn.click();
        return this;
    }

    public Header verifyHeader() {
        onlinerLogo.shouldBe(exist);
        search.shouldBe(exist);
        return this;
    }

    public Header goToProfile() {
        profileBtn.click();
        pause(5);
        profileName.click();
        return this;
    }

}