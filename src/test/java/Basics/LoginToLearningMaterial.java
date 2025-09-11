package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginToLearningMaterial {

    WebDriver driver;

    @BeforeTest
    public void launchBrowser() {
        driver = new ChromeDriver();
    }

    @Test
    public void openWebsite() throws InterruptedException {
        driver.get("https://www.ndosiautomation.co.za/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "openWebsite")
    public void verifyHomePageIsDisplayed() throws InterruptedException {
        driver.findElement(By.xpath("//h2[contains(.,'Learn Automation the Right Way')]")).isDisplayed();
        Thread.sleep(2000);
    }

    // This code cls the button
    @Test(dependsOnMethods = "verifyHomePageIsDisplayed")
    public void clickLearningMaterial() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/nav/div/ul/li[7]/button")).click();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "clickLearningMaterial")
    public void verifyLoginIsDisplayed() throws InterruptedException {
        String Login = driver.findElement(By.id("login-heading")).findElement(By.tagName("span")).getText();

        Assert.assertEquals(Login, "Access Learning Materials");
        System.out.println("The printed text is " + Login); // /html/body/div/div/main/section/div/h2
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "verifyLoginIsDisplayed")
    public void enterUsername() throws InterruptedException {
        driver.findElement(By.id("login-email")).sendKeys("njc@gmail.com");
        Thread.sleep(2000);
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
