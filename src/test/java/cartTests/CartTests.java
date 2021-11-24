package cartTests;

import com.codeborne.selenide.WebDriverRunner;
import driver.BaseTest;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.cart.CartPage;
import pageObject.catalog.CatalogMenuEnum;
import pageObject.catalog.CatalogPage;
import pageObject.catalog.ElectronicMenuEnum;
import pageObject.catalog.MobilePhoneMenuEnum;
import pageObject.filter.FilterPage;
import pageObject.header.Header;
import pageObject.product.ProductPage;
import patterns.UserBuilder;

public class CartTests extends BaseTest {
    UserBuilder user;

    @BeforeMethod
    public void preconditions() {
        get(Header.class)
                .goToCatalog();
        get(CatalogPage.class)
                .verifyCatalogPage()
                .chooseCatalogMenuCategory(CatalogMenuEnum.ELECTRONIC)
                .chooseElectronicMenu(ElectronicMenuEnum.MOBILE_PHONES_AND_ACCESSORIES)
                .chooseMobilePhoneMenu(MobilePhoneMenuEnum.FITNESS_BRACELETS);
        get(FilterPage.class)
                .verifyFilterPage()
                .chooseProduct();
    }

    // Данный тест не проходит на CI, проблемы с кириллицей. Локально тест работает.
    @Description("Change city of delivery in pop-up window")
    @Test
    public void checkPopUp_Test() {
        user = UserBuilder.builder()
                .city("Витебск")
                .build();
        get(ProductPage.class)
                .addToCart()
                .goToCart();
        get(CartPage.class)
                .changeDeliveryCity(user);
    }

    @Description("Checking for the maximum number of items in the cart")
    @Test
    public void checkMaxProductQuantity_Test() {
        get(ProductPage.class)
                .verifyProductPage()
                .addToCart()
                .goToCart();
        get(CartPage.class)
                .checkMaxProductQuantity();
    }

    @AfterMethod
    public void postconditions() {
        WebDriverRunner.closeWebDriver();
    }

}