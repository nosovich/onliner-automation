package pageObject.catalog;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public enum ElectronicMenuEnum {

    MOBILE_PHONES_AND_ACCESSORIES($(By.xpath("//div[contains(text(),'Мобильные телефоны')]"))),
    TELEVISION_AND_VIDEO($(By.xpath("//div[contains(text(),'Телевидение')]"))),
    TABLETS_AND_ELECTRONIC_BOOKS($(By.xpath("//div[contains(text(),'Планшеты')]"))),
    AUDIO_EQUIPMENT($(By.xpath("//div[contains(text(),'Аудиотехника')]"))),
    HIFI_AUDIO($(By.xpath("//div[contains(text(),'Hi-Fi аудио')]"))),
    PHOTOS_AND_VIDEO($(By.xpath("//div[contains(text(),'Фото- ')]"))),
    VIDEO_GAMES($(By.xpath("//div[contains(text(),'Видеоигры')]"))),
    GADGETS($(By.xpath("//div[contains(text(),'Гаджеты')]"))),
    SMARTHOUSE_AND_VIDEO($(By.xpath("//div[contains(text(),'Умный дом')]"))),
    ELECTRIC_TRANSPORT($(By.xpath("//div[contains(text(),'Электрический транспорт')]"))),
    TELEPHONY_AND_COMMUNICATION($(By.xpath("//div[contains(text(),'Телефония')]"))),
    MUSICAL_EQUIPMENT($(By.xpath("//div[contains(text(),'Музыкальное оборудование')]"))),
    OPTICAL_DEVICES($(By.xpath("//div[contains(text(),'Оптические приборы')]")));

    protected SelenideElement selenideElement;

    ElectronicMenuEnum(SelenideElement selenideElement) {
        this.selenideElement = selenideElement;
    }

    public SelenideElement getElement() {
        return selenideElement;
    }
}
