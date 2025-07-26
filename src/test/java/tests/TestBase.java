package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.jupiter.api.BeforeAll;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    public static class CustomMobileDriver implements WebDriverProvider {

        @Override
        public WebDriver createDriver(org.openqa.selenium.Capabilities capabilities) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("deviceName", "Pixel_3a_API_34_extension_level_7_x86_64");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/org.wikipedia.apk");
            caps.setCapability("appPackage", "org.wikipedia.alpha");
            caps.setCapability("appActivity", "org.wikipedia.main.MainActivity");
            caps.setCapability("newCommandTimeout", 3600);
            caps.setCapability("appium:connectHardwareKeyboard", true);

            try {
                return new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @BeforeAll
    public static void setup() {
        Configuration.browser = CustomMobileDriver.class.getName();
        Configuration.timeout = 10000;
        Configuration.browserSize = null;
    }
}
