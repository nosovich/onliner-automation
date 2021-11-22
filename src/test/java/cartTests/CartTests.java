package cartTests;

import driver.BaseTest;
import jdk.jfr.Description;
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

    @BeforeTest
    public void preconditions() {
        get(Header.class)
                .goToCatalog();
        get(CatalogPage.class)
                .verifyCatalogPage()
                .chooseCatalogMenuCategory(CatalogMenuEnum.ELECTRONIC)
                .chooseElectronicMenu(ElectronicMenuEnum.MOBILE_PHONES_AND_ACCESSORIES)
                .chooseMobilePhoneMenu(MobilePhoneMenuEnum.FITNESS_BRACELETS);

    }

    @Description("Checking for adding and removing items from the cart")
    @Test
    public void addAndRemoveProductToCart_Test() {
        get(FilterPage.class)
                .verifyFilterPage()
                .chooseProduct();
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
