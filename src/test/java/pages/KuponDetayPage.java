package pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import util.Karsilasmalar;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class KuponDetayPage extends BasePage {

    private static final Logger log = LogManager.getLogger(KuponDetayPage.class);

    public static final ArrayList<Karsilasmalar> _kupondas_detay_list = new ArrayList<>();

    By kupondasDetayPage = By.id(app_package_name + "recycler_view_events");
    By etkinlikisimleri = By.xpath("//android.widget.TextView[@resource-id='com.pordiva.nesine.android:id/tv_teams']");
    By hemen_oyna_button = By.id(app_package_name + "status_btn");

    public KuponDetayPage(AndroidDriver driver) {
        super(driver);
    }

    public void waitForKuponDetayPage() {
        waitDissappearElement();
        waitElementPresence(kupondasDetayPage);
        waitForVisibilityOf(kupondasDetayPage);
    }



    public void atKuponDetayEtkinlikIsimleri() {
        for (int i = 0; i < findElements(etkinlikisimleri).size(); i++) {
            _kupondas_detay_list.add(new Karsilasmalar(findElements(etkinlikisimleri).get(i).getText().trim()));
        }
        while (!isElementDisplayed(hemen_oyna_button)) {
            scrollDownScreen();
            for (int i = 0; i < findElements(etkinlikisimleri).size(); i++) {
                _kupondas_detay_list.add(new Karsilasmalar(findElements(etkinlikisimleri).get(i).getText().trim()));
            }
        }
        List<Karsilasmalar> distinct = _kupondas_detay_list.stream()
                .filter(distinctByKey(Karsilasmalar::getName))
                .collect(Collectors.toList());


        for (Karsilasmalar item: distinct){
            log.info(item.getName());
        }

        _kupondas_detay_list.clear();
        _kupondas_detay_list.addAll(distinct);

    }

    public void clickHemenOynaButton() {
        clickElement(hemen_oyna_button);
    }
}
