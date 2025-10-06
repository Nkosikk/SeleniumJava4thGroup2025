package Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginAndSessionTests extends Base {
    // Precondition
    @Test
    public void verifyHomePageIsDisplayedTests() {
        homePage.verifyHomePageIsDisplayed();
        takesScreenshots.takesSnapShot(driver, "Home Page");
    }

    // Precondition
    @Test(dependsOnMethods = "verifyHomePageIsDisplayedTests")
    public void clickLearningMaterialTests() {
        homePage.clickLearningMaterial();
    }

    // 1 Tabs visible
    @Test(dependsOnMethods = "clickLearningMaterialTests")
    public void verifyLoginPageIsDisplayedTests() {
        loginPage.verifyLoginPageIsDisplayed();
    }

    // 2 Invalid password
    @Test(dependsOnMethods = "verifyLoginPageIsDisplayedTests")
    public void enterInvalidPassword() {
        loginPage.enterEmailAddress("testuser");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();
        if (alertText.equals("Invalid email or password")) {
            System.out.println("Alert message is correct");
        } else {
            System.out.println("Unexpected alert: " + alertText);
        }
        alert.accept();

    }

    // 1 Valid credentials
    @Test(dependsOnMethods = "enterInvalidPassword")
    public void enterEmailPasswordLoginTests() {
        loginPage.enterEmailAddress(readFromExcel.username);
        loginPage.enterPassword(readFromExcel.password);
        loginPage.clickLoginButton();
    }

//    // 1 Token exists
//    @Test(dependsOnMethods = "enterEmailPasswordLoginTests")
//    public void tokenExists() {
//        String authToken = (String) ((JavascriptExecutor) driver)
//                .executeScript("return window.localStorage.getItem('authToken');");
//        Assert.assertNotNull(authToken, "authToken should exist in localStorage");
//    }

    // 4 Switch Tab to logout
    @Test(dependsOnMethods = "enterEmailPasswordLoginTests")
    public void switchTabLogout() {
        loginPage.clickContactDetailsTab();
        loginPage.clickLearningMaterial();
        loginPage.verifyLoginPageIsDisplayed();
    }

    // 3 Extra spaces
    @Test(dependsOnMethods = "switchTabLogout")
    public void extraSpacesLogin() {
        loginPage.enterEmailAddress(" " + readFromExcel.username + " ");
        loginPage.enterPassword(readFromExcel.password);
        loginPage.clickLoginButton();
    }

    // 5 Logout
    @Test(dependsOnMethods = "extraSpacesLogin")
    public void logout() {
        loginPage.clickLogout();
        loginPage.verifyLoginPageIsDisplayed();
    }

    // 5 Token doesnt exist

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
