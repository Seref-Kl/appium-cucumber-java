package pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import util.Karsilasmalar;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BasketPage extends BasePage {

    private static final Logger log = LogManager.getLogger(KuponDetayPage.class);

    public static final ArrayList<String> basket_list = new ArrayList<>();
    public static final ArrayList<Karsilasmalar> _basket_list = new ArrayList<>();
    By basketPage = By.id(app_package_name + "basket_coupon_top");
    By etkinlikIsimleri = By.id(app_package_name + "teamName");

    public BasketPage(AndroidDriver driver) {
        super(driver);
    }

    public void waitForBasketPage() {
        waitDissappearElement();
        waitElementPresence(basketPage);
        waitForVisibilityOf(basketPage);
    }

    public void atBasketEtkinlikIsimleri() {
        for (int i = 0; i < findElements(etkinlikIsimleri).size(); i++){
            _basket_list.add(new Karsilasmalar(findElements(etkinlikIsimleri).get(i).getText().trim()));
        }

        for (Karsilasmalar etkinlik_isim : _basket_list) {
            log.info(etkinlik_isim.getName());
        }
    }

    public void compareKuponDetayToBasket() {

        ArrayList<Karsilasmalar> kupon_detay_page_array = KuponDetayPage._kupondas_detay_list;

        Set<String> names = kupon_detay_page_array.stream()
                .map(Karsilasmalar::getName)
                .collect(Collectors.toSet());

        List<Karsilasmalar> parentList = _basket_list.stream()
                .filter(karsilasmalar -> !names.contains(karsilasmalar.getName()))
                .collect(Collectors.toList());


        if (parentList.isEmpty()){
            log.info("Etkinlik isimleri doğru bir şekilde görüntülenmiştir");
        }else{
            log.error("Etkinlik isimleri doğru bir şekilde görüntülenememiştir");
        }


    }
}
