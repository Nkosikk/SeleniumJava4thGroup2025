package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;
import utils.BrowserFactory;
import utils.TakesScreenshots;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = BrowserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/");
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    TakesScreenshots takesScreenshots = new TakesScreenshots();
}
