package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "login-heading")
    WebElement loginPageTitle_id;

    @FindBy(id = "login-email")
    WebElement emailField_id;

    @FindBy(id = "login-password")
    WebElement passwordField_id;

    @FindBy(id = "login-submit")
    WebElement loginButtonField_id;

    @FindBy(id = "nav-btn-contact")
    WebElement contactDetailsTabField_id;

    @FindBy(id = "nav-btn-practice")
    WebElement learningMaterialButton_id;

    @FindBy(id = "logout-button")
    WebElement clickLogoutButton_id;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLoginPageIsDisplayed() {
        loginPageTitle_id.isDisplayed();
    }

    public void enterEmailAddress(String email) {
        emailField_id.clear();
        emailField_id.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField_id.clear();
        passwordField_id.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButtonField_id.click();
    }

    public void clickContactDetailsTab() {
        contactDetailsTabField_id.click();
    }

    public void clickLearningMaterial() {
        learningMaterialButton_id.click();
    }

    public void clickLogout() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(visibilityOf(clickLogoutButton_id));
        clickLogoutButton_id.click();
    }
}

