package pageObject.Catalog;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import pageObject.BasePage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPage extends BasePage{

    SelenideElement title = $(".catalog-navigation__title");
    SelenideElement categoriesField = $(".catalog-navigation-classifier.catalog-navigation-classifier_active");

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
        categoriesField.shouldBe(visible);
        return this;
    }

}
