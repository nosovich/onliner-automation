package pageObject.catalog;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public enum MobilePhoneMenuEnum {

    SMARTPHONES($("a[href='https://catalog.onliner.by/mobile']")),
    HEADPHONES($("a[href='https://catalog.onliner.by/headphones']")),
    FITNESS_BRACELETS($("a[href='https://catalog.onliner.by/smartwatch?sw_type%5B0%5D=bracelet&sw_type%5Boperation%5D=union']")),
    SMARTWATCH($("a[href='https://catalog.onliner.by/smartwatch?sw_type%5B0%5D=watch&sw_type%5B1%5D=smartphonewatch&sw_type%5B2%5D=fitwatch&sw_type%5B3%5D=hybridsmartwatch&sw_type%5Boperation%5D=union&sw_kid=0']")),
    CHILDREN_WATCH_PHONE($("a[href='https://catalog.onliner.by/smartwatch?sw_type%5B0%5D=smartphonewatch&sw_type%5Boperation%5D=union&sw_kid=1']")),
    PORTABLE_CHARGING_DEVICES($("a[href='https://catalog.onliner.by/portablecharger']")),
    MEMORY_CARDS($("a[href='https://catalog.onliner.by/memcards?typememcards%5B0%5D=microsd&typememcards%5B1%5D=microsdxc&typememcards%5B2%5D=microsdhc&typememcards%5Boperation%5D=union']")),
    PHONECASES($("a[href='https://catalog.onliner.by/phonecase']")),
    PROTECTION_GLASSES($("a[href='https://catalog.onliner.by/protectiveglass']")),
    BATTERIES($("a[href='https://catalog.onliner.by/phoneaccum']")),
    BLUETOOTH_HEADSETS($("a[href='https://catalog.onliner.by/bt']")),
    SELFIE_STICKS($("a[href='https://catalog.onliner.by/selfiestick']")),
    CABLES_ADAPTERS($("a[href='https://catalog.onliner.by/cable?cable_usage%5B0%5D=phone&cable_usage%5Boperation%5D=union']")),
    CAR_HOLDERS($("a[href='https://catalog.onliner.by/carholder']")),
    CHARGERS_DEVICES($("a[href='https://catalog.onliner.by/chargersmobile?mc_devicetype%5B0%5D=type&mc_devicetype%5Boperation%5D=union&mc_type%5B0%5D=network&mc_type%5Boperation%5D=union']")),
    WIRELESS_CHARGERS($("a[href='https://catalog.onliner.by/chargersmobile?mc_type%5B0%5D=wireless&mc_type%5Boperation%5D=union']")),
    DOCKSTATIONS_FOR_SMARTPHONES($("a[href='https://catalog.onliner.by/speakerdock']")),
    BUTTON_PHONES($("a[href='https://catalog.onliner.by/mobile?mobile_type%5B0%5D=phone&mobile_type%5Boperation%5D=union']"));

    SelenideElement selenideElement;

    MobilePhoneMenuEnum(SelenideElement selenideElement) {
        this.selenideElement = selenideElement;
    }

    public SelenideElement getElement(){
        return selenideElement;
    }
}
