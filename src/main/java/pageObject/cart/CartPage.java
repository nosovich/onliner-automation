package pageObject.cart;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import pageObject.BasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BasePage {

    SelenideElement onlinerLogo = $("a[href='https://www.onliner.by']");
    SelenideElement title = $("[class^='cart-form__title']");
    SelenideElement productInCart = $("[class*='cart-form__description_font-weight_semibold']");
    SelenideElement productDescription = $("div[class$='cart-form__description_condensed-complementary helpers_hide_tablet']");
    SelenideElement productQuantity = $("[class*='cart-form__input_max-width_xxxxsssss cart-form__input_nonadaptive']");
    SelenideElement removeProductBtn = $("[class$='cart-form__button_remove']");

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
        moveToElement(removeProductBtn);
        removeProductBtn.shouldBe(enabled).click();
        productInCart.should(disappear);
        return this;
    }

    public CartPage goToHomePage() {
        onlinerLogo.click();
        return this;
    }
}
