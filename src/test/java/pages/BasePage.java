package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;

public class BasePage {

    private final Logger log = LogManager.getLogger(BasePage.class);


    protected AndroidDriver driver;
    private TouchAction action;

    String app_package_name = "com.pordiva.nesine.android:id/";

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.action = new TouchAction(driver);
    }

    protected void waitForVisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForClickabilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitElementPresence(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitDissappearElement() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(app_package_name + "animation_view")));
    }

    public boolean isElementDisplayed(By by) {
        try {
            log.info("Element Displayed Control : " + by);
            return findElement(by).isDisplayed();
        } catch (Exception e) {
            log.debug("Element Is Not Displayed", e);
            return false;
        }
    }

    public void elementDisplayedControlWithSwipe(By by) {
        for (int i = 0; i < 4; i++) {
            if (!isElementDisplayed(by)) {
                scrollDownScreen();
                log.info((i + 1) + ". kez swipe yapıldı !");

            } else {
                log.info(by + " görüldü!");
                break;
            }
        }

    }

    public void timeUnitSeconds(int sleepTime) {
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }

    public void scrollDownScreen() {
        Dimension d = driver.manage().window().getSize();
        int height = d.height;
        int width = d.width;
        int swipeStartWidth = (width * 50) / 100;
        int swipeEndWidth = (width * 50) / 100;
        int swipeStartHeight = (height * 3) / 4;
        int swipeEndHeight = height / 4;
        action.press(swipeStartWidth, swipeStartHeight).waitAction(5000)
                .moveTo(swipeEndWidth, swipeEndHeight).release()
                .perform();
    }

    public MobileElement findElement(By by) {
        waitDissappearElement();
        return (MobileElement) driver.findElement(by);
    }

    public List<MobileElement> findElements(By by) {
        waitDissappearElement();
        return driver.findElements(by);
    }

    public void sendKeys(By by, String text) {
        try {
            elementDisplayedControlWithSwipe(by);
            waitForClickabilityOf(by);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            log.error(by + " görülmedi!");
        }
        findElement(by).clear();
        findElement(by).sendKeys(text);
    }

    public void sendKeys(By by, String text, int index) {
        try {
            elementDisplayedControlWithSwipe(by);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            log.error(by + " görülmedi!");
        }
        findElements(by).get(index).clear();
        findElements(by).get(index).sendKeys(text);
    }

    public void clickElement(By by) {
        try {
            elementDisplayedControlWithSwipe(by);
            waitForClickabilityOf(by);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            log.error(by + " görülmedi!");
        }
        findElement(by).click();
    }

    public void clickElement(By by, int index) {
        try {
            elementDisplayedControlWithSwipe(by);
            waitForClickabilityOf(by);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            log.error(by + " görülmedi!");
        }
        findElements(by).get(index).click();
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
