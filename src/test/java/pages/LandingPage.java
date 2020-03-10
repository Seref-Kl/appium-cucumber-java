package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LandingPage extends BasePage {

    By landingPage = By.id(app_package_name + "top_home_page");
    By girisYapButton = By.id(app_package_name + "btn_login");

    public LandingPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void waitForLandingPage() {
        waitElementPresence(landingPage);
        waitForVisibilityOf(landingPage);
    }

    public void clickGirisYapButton() {
        clickElement(girisYapButton);
    }
}