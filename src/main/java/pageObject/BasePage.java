package pageObject;

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
}
