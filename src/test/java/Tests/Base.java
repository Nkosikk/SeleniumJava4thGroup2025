package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Utils.BrowserFactory;
import Utils.ReadFromExcel;
import Utils.TakesScreenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("edge", "https://www.ndosiautomation.co.za/");
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
