package pageObject.cart;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pageObject.BasePage;
import patterns.UserBuilder;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BasePage {

    SelenideElement onlinerLogo = $("a[href='https://www.onliner.by']");
    SelenideElement title = $("[class^='cart-form__title']");
    SelenideElement productInCart = $("[class*='cart-form__description_font-weight_semibold']");
    SelenideElement productQuantity = $("[class*='cart-form__input_max-width_xxxxsssss cart-form__input_nonadaptive']");
    SelenideElement removeProductBtn = $("[class$='cart-form__button_remove']");
    SelenideElement deliveryCity = $("a[class='cart-form__link cart-form__link_primary cart-form__link_base-alter']");
    SelenideElement enterCity = $("[class*='auth-input auth-input_primary auth-input_base']");
    SelenideElement changeCityBtn = $("button[class^='auth-button auth-button_primary']");
    SelenideElement closePopUpBtn = $("span[class='auth-popup__close']");


    SelenideElement popUpField = $("[class='auth-form__mediabox auth-form__mediabox_primary auth-form__mediabox_extended']");


    public CartPage verifyCartPage() {
        onlinerLogo.shouldBe(exist);
        title.shouldBe(visible);
        return this;
    }

    public CartPage checkProductInCart() {
        productInCart.shouldBe(visible);
        productQuantity.click();
        return this;
    }

    public CartPage checkMaxProductQuantity() {
        productQuantity.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        productQuantity.sendKeys(Keys.chord(Keys.DELETE));
        productQuantity.setValue("100");
        productQuantity.getValue().equals("10");
        return this;
    }

    public CartPage removeProduct() {
        moveToElement(removeProductBtn).shouldBe(enabled).click();
        productInCart.should(disappear);
        return this;
    }

    public CartPage goToHomePage() {
        onlinerLogo.click();
        return this;
    }

    public CartPage changeDeliveryCity(UserBuilder user) {
        deliveryCity.click();
        moveToElement(enterCity).setValue(user.getCity());
        pause(3);
        enterCity.pressEnter();
        changeCityBtn.click();
        moveToElement(deliveryCity).should(matchText(user.getCity()));
        return this;
    }

}
