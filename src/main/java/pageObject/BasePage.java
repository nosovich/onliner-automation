package pageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.Waiter;

public class BasePage {
    public void pause(Integer seconds) {
        try {
            long time = seconds * 1000;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public SelenideElement moveToElement(SelenideElement element) {
        Selenide.actions().moveToElement(element);
        return element;
    }
}

