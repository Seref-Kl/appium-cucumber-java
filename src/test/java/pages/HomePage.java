package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


public class HomePage extends BasePage {

    By homePage = By.id(app_package_name + "my_account_layout");
    By kupondas_button = By.xpath("(//android.widget.HorizontalScrollView[@resource-id=\"com.pordiva.nesine.android:id/n6_master_tab_layout\"]//android.widget.TextView)[5]");


    public HomePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void waitForHomePage() {
        waitForVisibilityOf(homePage);
    }

    public void clickKupondasButton(){
        clickElement(kupondas_button);
    }
}
