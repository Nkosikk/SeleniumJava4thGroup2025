package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import utils.BrowserFactory;

public class Base {

    final WebDriver driver = BrowserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za");
    BrowserFactory browserFactory = new BrowserFactory();
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);

}
