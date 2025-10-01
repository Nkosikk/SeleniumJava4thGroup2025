package tests;

import pages.HomePage;
import pages.LoginPage;
import utils.BrowserFactory;
import utils.ReadFromExcel;
import utils.TakesScreenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/");
    HomePage homePage= PageFactory.initElements(driver,HomePage.class);
    LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);

    TakesScreenshots takesScreenshots = new TakesScreenshots();

    ReadFromExcel readFromExcel;
    {
        try{
            readFromExcel= new ReadFromExcel();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
