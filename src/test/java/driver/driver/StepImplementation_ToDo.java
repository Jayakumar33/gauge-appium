package driver.driver;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class StepImplementation_ToDo {


    private AppiumDriver<MobileElement> driver;

    public StepImplementation_ToDo() {
        this.driver = DriverFactory.getDriver();
    }

    @Step("Open the todo app")
    public void gotoApp() throws InterruptedException {

        System.out.println(this.driver);
    }

    @Step("Select the desired items")
    public void selectItems() throws InterruptedException {

        MobileElement color = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/color");
        //Changes color to pink
        color.click();
        Thread.sleep(1000);
        //Back to orginal color
        color.click();

        MobileElement text = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/Text");
        //Changes the text to "Proverbial"
        text.click();

        //toast will be visible
        MobileElement toast = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/toast");
        toast.click();

        //notification will be visible
        MobileElement notification = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/notification");
        notification.click();
        Thread.sleep(2000);

        //Opens the geolocation page
        MobileElement geo = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/geoLocation");
        geo.click();
        Thread.sleep(5000);

        //takes back to home page
        MobileElement home = (MobileElement) driver.findElementByAccessibilityId("Home");
        home.click();

    }

    @Step("Add new item <itemName>")
    public void addNewItem(String itemName) throws InterruptedException {


        //Takes to speed test page
        MobileElement speedtest = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/speedTest");
        speedtest.click();
        Thread.sleep(5000);

        MobileElement Home = (MobileElement) driver.findElementByAccessibilityId("Home");
        Home.click();

        //Opens the browser
        MobileElement browser = (MobileElement) driver.findElementByAccessibilityId("Browser");
        browser.click();

        MobileElement url = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/url");
        url.sendKeys("https://www.lambdatest.com");

        MobileElement find = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/find");
        find.click();
        driver.quit();
    }
}
