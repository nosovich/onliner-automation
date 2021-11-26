package cartTests;

import driver.BaseTest;
import io.qameta.allure.Description;
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
import patterns.UserBuilder;

public class AddAndRemoveTest extends BaseTest {

    @BeforeTest
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


}
