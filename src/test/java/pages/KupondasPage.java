package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class KupondasPage extends BasePage {


    By kupondasPage = By.id(app_package_name + "search_btn");
    By tum_paylasimlar = By.xpath("(//android.widget.HorizontalScrollView[@resource-id='"+app_package_name+"tabs']//android.widget.TextView)[2]");
    By hemen_oyna_list = By.id(app_package_name + "status_btn");

    public KupondasPage(AndroidDriver driver){super(driver);}

    public void waitForKupondasPage() {
        waitDissappearElement();
        waitForVisibilityOf(kupondasPage);
    }
    public void clickTumPaylasımlar(){
        clickElement(tum_paylasimlar);
    }
    public void clickHemenOynaListIndex(int sira){
        clickElement(hemen_oyna_list,sira);
    }
}
