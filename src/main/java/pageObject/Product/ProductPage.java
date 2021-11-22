package pageObject.Product;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import pageObject.BasePage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage extends BasePage {

    SelenideElement productNameTitle = $("catalog-masthead__title");
    SelenideElement addToCartBtn = $("[class='product-aside__box'] [class*='button-style_expletive']");
    SelenideElement goToCartBtn = $("[class$='product-recommended__control_checkout']>a[class$='product-recommended__button']");
    SelenideElement priceChartBtn = $("a[class*='button_white button_big']");
    SelenideElement popUpPriceChart = $("div[class='popup-style__content']");
    SelenideElement popUpPriceChartTitle = $("div[class='offers-form__title offers-form__title_middle-alter']");
    SelenideElement popUpPriceChartCheckbox = $("[class*='i-checkbox offers-form']");
    SelenideElement closePopUp = $(".popup-style__close");


    public ProductPage verifyProductPage() {
        productNameTitle.shouldBe(visible);
        return this;
    }

    public ProductPage addToCart() {
        addToCartBtn.click();
        return this;
    }

    public ProductPage goToCart() {
        goToCartBtn.click();
        return this;
    }

    public ProductPage checkPopUpPriceChart() {
        priceChartBtn.click();
        popUpPriceChart.shouldBe(visible);
        popUpPriceChartTitle.shouldBe(visible);
        popUpPriceChartCheckbox.shouldNotBe(enabled);
        closePopUp.click();
        return this;
    }
}