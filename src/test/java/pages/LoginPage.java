package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    By loginPage = By.id(app_package_name + "login_btn");
    By login_button = By.id(app_package_name + "login_btn");
    By kullanici_adi = By.id(app_package_name + "username_edit");
    By parola_alani = By.id(app_package_name + "password_edit");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void waitForLoginPage() {
        waitForVisibilityOf(loginPage);
    }

    public void sendKeysKullanciAdiParolaAndGirisYap(String kullaniciAdi, String parola) {
        sendKeys(kullanici_adi,kullaniciAdi);
        sendKeys(parola_alani,parola);
        clickElement(login_button);
    }
}
