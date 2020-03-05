package driver;


import cucumber.api.Scenario;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class DriverFactory {
    protected static AndroidDriver driver;
    public static final String appName = "nesine.com.apk";
    public static final String APP_DIR = System.getProperty("user.dir") + "/apps";

    public DriverFactory() throws MalformedURLException {
        initializeAppiumSession();
    }

    protected void initializeAppiumSession() throws MalformedURLException {
        configureSessionForDevice();
//        configureSessionForEmulator();
    }

    // Enter your android device details
    private void configureSessionForDevice() throws MalformedURLException {
        File app = getAppFile();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", Device.device);

        //mandatory capabilities
        capabilities.setCapability("appPackage", Device.appPackage);
        capabilities.setCapability("appActivity", Device.appActivity);
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("sendKeyStrategy", "oneByOne");
        capabilities.setCapability("clearSystemFiles", "true");
        capabilities.setCapability("deviceName", Device.deviceName);
        capabilities.setCapability("platformName", Device.platformName);

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL(Device.URL), capabilities);
    }

    private File getAppFile() {
        File appDir = new File(APP_DIR);
        return new File(appDir, appName);
    }

    public void killAppiumSession() {
        driver.quit();
    }
}
