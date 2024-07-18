package driver.driver;

import com.thoughtworks.gauge.AfterSpec;
import com.thoughtworks.gauge.BeforeSpec;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static final String LT_USERNAME = System.getenv("LT_USERNAME");
    private static final String LT_ACCESS_KEY = System.getenv("LT_ACCESS_KEY");
    private static final String GRID_URL = "@mobile-hub.lambdatest.com/wd/hub";

    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        if (driver == null) {
            setUpDriver();
        }
        return driver;
    }

    private static void setUpDriver() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Galaxy S21 5G");
            capabilities.setCapability("platformVersion", "11");
            capabilities.setCapability("app", "lt://proverbial-android");
            capabilities.setCapability("isRealMobile", true);
            capabilities.setCapability("build", "Gauge-Appium-Java");
            capabilities.setCapability("name", "Sample Script");
            capabilities.setCapability("network", false); // To enable network logs
            capabilities.setCapability("visual", true); // To enable step by step screenshot
            capabilities.setCapability("console", false); // To capture console logs

            String url = "https://" + LT_USERNAME + ":" + LT_ACCESS_KEY + GRID_URL;
            driver = new AppiumDriver<>(new URL(url), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid app URL");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterSpec
    public void tearDown() {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + "passed");
            driver.quit();
        }
    }
}
