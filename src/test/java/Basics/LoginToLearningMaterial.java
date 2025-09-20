package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginToLearningMaterial {

    WebDriver driver;


    @BeforeTest
    public void launchBrowser() {
        driver = new ChromeDriver();
    }

    @Test
    public void startBrowser() throws InterruptedException {
        driver.get("https://www.ndosiautomation.co.za");
        driver.manage().window().maximize();
        Thread.sleep(2000);

    }

    @Test(dependsOnMethods = "startBrowser")
    public void verifyHomePageISDisplayed() throws InterruptedException {
        driver.findElement(By.xpath("//h2[contains(.,'Learn Automation the Right Way')]")).isDisplayed();
        Thread.sleep(2000);
    }

    // This code cls the button
    @Test(dependsOnMethods = "verifyHomePageISDisplayed")
    public void clickLearningMaterial() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/nav/div/ul/li[7]/button")).click();
        Thread.sleep(2000);
    }



    @Test(dependsOnMethods = "clickLearningMaterial")
    public void verifyloginDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        // Wait for the span with the expected text
        String loginText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(),'Access Learning Materials')]")
        )).getText();

        Assert.assertEquals(loginText, "Access Learning Materials");
        System.out.println("The printed text is " + loginText);
    }

    @Test(dependsOnMethods = "verifyloginDisplayed")
    public void enterUsername() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"login-email\"]")).sendKeys("njc@gmail.com");
        Thread.sleep(2000);
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
