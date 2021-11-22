package pageObject.Home;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import pageObject.BasePage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage extends BasePage {

    ElementsCollection onlinerСategories = $$(By.cssSelector(".b-main-page-blocks-header-2.cfix>h2"));

    public HomePage verifyHomePage() {
        onlinerСategories.shouldHave(size(10));
        return this;
    }
}
