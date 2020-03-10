package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import pages.*;

import java.net.MalformedURLException;


public class Steps extends DriverFactory {

    private final Logger log = LogManager.getLogger(Steps.class);

    public Steps() throws MalformedURLException {
    }


    @Given("\"(\\d+)\" saniye beklenir$")
    public void saniyeBeklenir(int time){
        new BasePage(driver).timeUnitSeconds(time);
    }

    @Given("^Acilis sayfasindayim$")
    public void acilisSayfasindayim() {
        try {
            new LandingPage(driver).waitForLandingPage();
            log.info("Nesine uygulaması açıldı.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Assert.fail("Açılış sayfası görülmedi");
        }

    }

    @When("^Giris yap butonuna tikla$")
    public void girisYapButonunaTikla() {
        try {
            new LandingPage(driver).clickGirisYapButton();
            log.info("Giriş yap butonuna tıklandı.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Assert.fail("Giriş yap butonuna tıklamada bir hata oldu.");
        }
    }

    @Then("^Login sayfasindayim$")
    public void loginSayfasindayim() {
        try {
            new LoginPage(driver).waitForLoginPage();
            log.info("Login sayfası açıldı.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Assert.fail("Login sayfası görülmedi.");
        }
    }

    @When("^Kulanici adi alanina \"([^\"]*)\" parola alanina \"([^\"]*)\" degerleri yaz ve giris yap$")
    public void kullaniciAdiAlaninaParolaAlaninaDegerleriYazVeGirisYap(String kullaniciAdi, String parola) {
        try {
            new LoginPage(driver).sendKeysKullanciAdiParolaAndGirisYap(kullaniciAdi, parola);
            log.info("Üye No: " + kullaniciAdi + " ve Parola: " + parola + " ile başarılı bir şekilde login olundu.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Assert.fail("Login sayfasında kullanıcı adi parola girişinde veya login işleminde hata ile karşılaşıldı.");
        }
    }

    @Then("^Anasayfadayim$")
    public void anasayfadayim() {
        try {
            new HomePage(driver).waitForHomePage();
            log.info("Anasayfa açıldı.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Assert.fail("Anasayfa görülmedi.");
        }
    }

    @When("^kupondas butonuna tıklanır$")
    public void kupondasButonunaTıklanır() {
        try {
            new HomePage(driver).clickKupondasButton();
            log.info("Kupondaş butonuna tıklandı.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Assert.fail("Kupondaş butonuna tıklamada bir hata oluştu");
        }
    }

    @Then("^Kupondas sayfasindayim$")
    public void kupondasSayfasindayim() {
        try {
            new KupondasPage(driver).waitForKupondasPage();
            log.info("Kupondaş Sayfası açıldı.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Assert.fail("Kupondaş sayfası görülmedi.");
        }
    }

    @When("^Tum paylasimlar butonuna tikla$")
    public void tumPaylasimlarButonunaTikla() {
        try {
            new KupondasPage(driver).clickTumPaylasımlar();
            log.info("Tüm paylaşımlar sekmesine tıklandı.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Assert.fail("Tüm paylaşımlar sekmesine tıklamada bir hata oluştu.");
        }

    }


    @And("^Ilk hemen oyna butonu secilir$")
    public void ilkHemenOynaButonuSecilir() {
        int sira = 1;
        try {
            new KupondasPage(driver).clickHemenOynaListIndex(sira-1);
            log.info("Hemen oyna butonlarından ilkine tıklandı.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Assert.fail("İlk hemen oyna butonu tıklamada bir hata oluştu.");
        }
    }

    @Then("^Kupondas detay sayfasindayim$")
    public void kupondasDetaySayfasindayim() {
        try {
            new KuponDetayPage(driver).waitForKuponDetayPage();
            log.info("Kupondaş detay sayfası açıldı.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Assert.fail("Kupondaş detay sayfası görülmedi.");
        }
    }

    @When("^Kupondas detay sayfasindaki etkinlik isimlerini kaydet$")
    public void kupondasDetaySayfasindakiEtkinlikIsimleriniKaydet() {
        try {
            new KuponDetayPage(driver).atKuponDetayEtkinlikIsimleri();
            log.info("Kupon Detay etkinlik isimleri kaydedildi.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Assert.fail("İsimleri kaydederken hata oluştu.");
        }

    }

    @And("^Hemen oyna butanuna tıkla$")
    public void hemenOynaButanunaTıkla() {
        try {
            new KuponDetayPage(driver).clickHemenOynaButton();
            log.info("Hemen oyna butonuna tıklandı.");

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Assert.fail("Hemen oyna butonuna tıklamada bir hata oluştu.");
        }
    }

    @Then("^Basket sayfasındayim$")
    public void basketSayfasındayim() {
        try {
            new BasketPage(driver).waitForBasketPage();
            log.info("Basket sayfasındayım.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Assert.fail("Basket sayfası görülmedi.");
        }
    }

    @When("^Basket sayfasindaki etkinlik isimlerini kaydet$")
    public void basketSayfasindakiEtkinlikIsimleriniKaydet() {
        try {
            new BasketPage(driver).atBasketEtkinlikIsimleri();
            log.info("Basket etkinlik isimleri kaydedildi.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Assert.fail("İsimleri kaydederken hata oluştu.");
        }
    }

    @Then("^Kupondas detay ve basket sayfalarindaki etkinlik isimlerini karsilastir$")
    public void kupondasDetayVeBasketSayfalarindakiEtkinlikIsimleriniKarsilastir() {
        try {
            new BasketPage(driver).compareKuponDetayToBasket();
            log.info("Karşılaştırma yapıldı.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Assert.fail("Karşılaştırma yapılamadı.");
        }
    }

    @After
    public void tearDown() {
        killAppiumSession();
    }

}
