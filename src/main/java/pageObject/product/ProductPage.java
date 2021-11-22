package pageObject.product;

import com.codeborne.selenide.SelenideElement;
import pageObject.BasePage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage extends BasePage {

    SelenideElement productNameTitle = $("h1[class='catalog-masthead__title']");
    SelenideElement addToCartBtn = $("[class='product-aside__box'] [class*='button-style_expletive']");
    SelenideElement goToCartBtn = $(".auth-bar.auth-bar--top > a");
    SelenideElement priceChartBtn = $("a[class*='button_white button_big']");
    SelenideElement popUpPriceChart = $("div[class='popup-style__content']");
    SelenideElement popUpPriceChartTitle = $("div[class='offers-form__title offers-form__title_middle-alter']");
    SelenideElement closePopUp = $(".popup-style__close");


    public ProductPage verifyProductPage() {
        moveToElement(productNameTitle);
        productNameTitle.shouldBe(visible);
        return this;
    }

    public ProductPage addToCart() {
        moveToElement(addToCartBtn);
        addToCartBtn.click();
        return this;
    }

    public ProductPage goToCart() {
        moveToElement(goToCartBtn);
        goToCartBtn.click();
        return this;
    }

    public ProductPage checkPopUpPriceChart() {
        priceChartBtn.click();
        popUpPriceChart.shouldBe(visible);
        popUpPriceChartTitle.shouldBe(visible);
        closePopUp.click();
        return this;
    }
}