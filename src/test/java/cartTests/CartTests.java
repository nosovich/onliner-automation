package cartTests;

import com.codeborne.selenide.WebDriverRunner;
import driver.BaseTest;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.cart.CartPage;
import pageObject.catalog.CatalogMenuEnum;
import pageObject.catalog.CatalogPage;
import pageObject.catalog.ElectronicMenuEnum;
import pageObject.catalog.MobilePhoneMenuEnum;
import pageObject.filter.FilterPage;
import pageObject.header.Header;
import pageObject.product.ProductPage;

public class CartTests extends BaseTest {

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

    @Description("Checking for adding and removing items from the cart")
    @Test
    public void addAndRemoveProductToCart_Test() {
        get(ProductPage.class)
                .verifyProductPage()
                .addToCart()
                .goToCart();
        get(CartPage.class)
                .verifyCartPage()
                .checkProductInCart()
                .removeProduct();
    }

    @Test
    public void checkPopUp_Test() {
        get(ProductPage.class)
                .checkPopUpPriceChart();
    }

    @AfterMethod
    public void postconditions() {
        WebDriverRunner.closeWebDriver();
    }


}
