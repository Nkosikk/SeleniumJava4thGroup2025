package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "login-heading")
    WebElement loginPageTitle_id;

    @FindBy(id = "login-email")
    WebElement email_id;

    @FindBy(id = "login-password")
    WebElement password_id;

    @FindBy(id = "login-submit")
    WebElement loginButton_id;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLoginPageIsDisplayed() {
        loginPageTitle_id.isDisplayed();
    }

    public void enterEmail(String email) {
        email_id.sendKeys("yoyo@gmail.com");
    }

    public void enterPassword(String password) {
        password_id.sendKeys("Yoyo2007");
    }

    public void clickLoginButton() {
        loginButton_id.click();
    }

}
