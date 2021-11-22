package pageObject.filter;

import patterns.PriceFilter;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObject.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FilterPage extends BasePage {

    SelenideElement title = $(".schema-header__title");
    SelenideElement product = $("span[data-bind*='extended_name']");
    ElementsCollection productNames = $$("span[data-bind*='extended_name']");
    ElementsCollection productPrices = $$("span[data-bind*='minPrice']");
    SelenideElement minPriceField = $(By.xpath("//input[@placeholder='от']"));
    SelenideElement maxPriceField = $(By.xpath("(//input[@class='schema-filter-control__item schema-filter__number-input schema-filter__number-input_price'])[2]"));

    public FilterPage verifyFilterPage() {
        pause(10);
        title.shouldBe(visible);
        product.shouldBe(visible);
        return this;
    }

    public FilterPage chooseProduct() {
        product.click();
        return this;
    }

    public FilterPage getProductName() {
        product.getText();
        return this;
    }

    public FilterPage enterMinPrice(PriceFilter priceFilter) {
        minPriceField.setValue(priceFilter.getMinPrice());
        pause(5);
        return this;
    }

    public FilterPage enterMaxPrice(PriceFilter priceFilter) {
        maxPriceField.setValue(priceFilter.getMaxPrice());
        pause(5);
        return this;
    }

    public FilterPage checkPriceFilter(PriceFilter priceFilter) {
        List<String> pricesData = new ArrayList<>();
        pause(10);
        productPrices.forEach(data -> pricesData
                .add(data.getText().split(" ")[0].replace(",", ".")));
        List<Double> prices = pricesData
                .stream()
                .map(Double::parseDouble).sorted()
                .collect(Collectors.toList());
        Assert.assertTrue(prices.get(0) > Integer.parseInt(priceFilter.getMinPrice())-1);
        Assert.assertTrue(prices.get(prices.size()-1) < Integer.parseInt(priceFilter.getMaxPrice())+1);
        return this;
    }

}
