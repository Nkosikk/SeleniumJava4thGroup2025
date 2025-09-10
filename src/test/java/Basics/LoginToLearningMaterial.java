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
    public void startBrowser() throws InterruptedException {
        driver.get("www.ndosiautomation.co.za");
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
    public void verifyloginDisplayed() throws InterruptedException {
        String Login = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/div/h2/span")).getText();

        Assert.assertEquals(Login,"Access Learning Materials");
        System.out.println("The printed text is " +Login);
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "verifyloginDisplayed")
    public void enterUsername() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/div/input[1]")).sendKeys("njc@gmail.com");
        Thread.sleep(2000);
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
