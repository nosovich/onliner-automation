package pageObject.catalog;

import com.codeborne.selenide.SelenideElement;
import pageObject.base.BasePage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPage extends BasePage{

    SelenideElement title = $(".catalog-navigation__title");

    public CatalogPage chooseCatalogMenuCategory(CatalogMenuEnum catalogMenuEnum) {
        catalogMenuEnum.getElement().click();
        return this;
    }

    public CatalogPage chooseElectronicMenu(ElectronicMenuEnum electronicMenuEnum) {
        electronicMenuEnum.getElement().click();
        return this;
    }

    public CatalogPage chooseMobilePhoneMenu(MobilePhoneMenuEnum mobilePhoneMenuEnum) {
        mobilePhoneMenuEnum.getElement().click();
        return this;
    }

    public CatalogPage verifyCatalogPage() {
        title.shouldBe(exist);
        return this;
    }

}
