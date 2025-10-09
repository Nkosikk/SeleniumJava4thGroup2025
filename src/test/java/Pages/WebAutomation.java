package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebAutomation {
    WebDriver driver;

    @BeforeTest
            public void launchBrowser() {
        driver = new ChromeDriver();
    }

    @Test
        public void startBrowser() throws InterruptedException{
        driver.get("https://ndosiautomation.co.za/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }
}
