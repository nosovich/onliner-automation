package filterProductTests;

import driver.BaseTest;
import jdk.jfr.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.catalog.CatalogMenuEnum;
import pageObject.catalog.CatalogPage;
import pageObject.catalog.ElectronicMenuEnum;
import pageObject.catalog.MobilePhoneMenuEnum;
import pageObject.filter.FilterPage;
import pageObject.header.Header;
import patterns.PriceFilter;

public class FilterTests extends BaseTest {
    PriceFilter priceFilter = new PriceFilter();

    @BeforeTest
    public void preconditions() {
        priceFilter.setMinPrice("1000");
        priceFilter.setMaxPrice("1500");
    }

    @Description("Checking product filtration by price 'from' 'to'")
    @Test
    public void checkFilterByPrice() {
        get(Header.class)
                .goToCatalog();
        get(CatalogPage.class)
                .chooseCatalogMenuCategory(CatalogMenuEnum.ELECTRONIC)
                .chooseElectronicMenu(ElectronicMenuEnum.MOBILE_PHONES_AND_ACCESSORIES)
                .chooseMobilePhoneMenu(MobilePhoneMenuEnum.SMARTPHONES);
        get(FilterPage.class)
                .enterMinPrice(priceFilter)
                .enterMaxPrice(priceFilter)
                .checkPriceFilter(priceFilter);

    }
}
