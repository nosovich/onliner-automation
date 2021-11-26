package productPageTests;

import driver.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObject.catalog.CatalogMenuEnum;
import pageObject.catalog.CatalogPage;
import pageObject.catalog.ElectronicMenuEnum;
import pageObject.catalog.MobilePhoneMenuEnum;
import pageObject.filter.FilterPage;
import pageObject.header.Header;
import pageObject.product.ProductPage;

public class ProductPageTests extends BaseTest {

    @Description("Checking for pop-up window with prices changes")
    @Test()
    public void checkPopUp_Test() {
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
        get(ProductPage.class)
                .checkPopUpPriceChart();
    }
}
