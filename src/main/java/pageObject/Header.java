package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Header extends BasePage {

    SelenideElement catalogBtn = $("a[href='https://catalog.onliner.by/']");
    SelenideElement onlinerLogo = $(".onliner_logo");
    SelenideElement search = $(".fast-search__form");
    SelenideElement cartIcon = $(".auth-bar.auth-bar--top > a");
    SelenideElement loginBtn = $("[class='auth-bar__item auth-bar__item--text']");


    ElementsCollection navigationMenu = $$(By.cssSelector(".b-main-navigation"));

    public Header goToCatalog() {
        catalogBtn.shouldBe(enabled).click();
        return this;
    }

    public Header goToLoginPage() {
        loginBtn.click();
        return this;
    }

    public Header verifyHeader() {
        onlinerLogo.shouldBe(exist);
        cartIcon.shouldBe(exist);
        search.shouldBe(exist);
        return this;
    }

}
