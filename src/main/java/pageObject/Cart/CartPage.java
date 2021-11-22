package pageObject.Cart;

import com.codeborne.selenide.SelenideElement;
import pageObject.BasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BasePage {

    SelenideElement onlinerLogo = $("a[href='https://www.onliner.by']");
    SelenideElement title = $("[class^='cart-form__title']");
    SelenideElement productInCart = $("[class*='cart-form__description_font-weight_semibold']");
    SelenideElement productQuantity = $("[class*='cart-form__input_nonadaptive']");
    SelenideElement removeProductBtn = $("[class$='cart-form__button_remove']");

    public CartPage verifyCartPage() {
        onlinerLogo.shouldBe(exist);
        title.shouldBe(visible);
        return this;
    }

    public CartPage checkProductInCart() {
        productInCart.shouldBe(visible);
        return this;
    }

    public CartPage checkMaxProductQuantity() {
        productQuantity.clear();
        productQuantity.setValue("100");
        productQuantity.should(matchText("10"));
        return this;
    }

    public CartPage removeProduct() {
        removeProductBtn.click();
        productInCart.should(disappear);
        return this;
    }

    public CartPage goToHomePage() {
        onlinerLogo.click();
        return this;
    }
}
