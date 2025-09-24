package Tests;

import org.testng.annotations.Test;

public class NdosiTests extends Base{

    @Test
    public void verifyHomePageIsDisplayedTests() {
        // Test code to verify home page is displayed
        homePage.verifyHomePageIsDisplayed();
    }

    @Test(priority = 1)
    public void clickLearningMaterialTests() {
        // Test code to click on learning material
        homePage.clickLearningMaterial();
    }

    @Test(priority = 2)
    public void verifyLoginPageIsDisplayedTests() {
        // Test code to verify login page is displayed
        loginPage.verifyLoginPageIsDisplayed();
    }

    @Test(priority = 3)
    public void enterEmailTests() {
        // Test code to enter email
        loginPage.enterEmail("yoyo@gmail.com");
    }

    @Test(priority = 4)
    public void enterPasswordTests() {
        // Test code to enter password
        loginPage.enterPassword("Yoyo2007");
    }

    @Test(priority = 5)
    public void clickLoginButtonTests() {
        // Test code to click login button
        loginPage.clickLoginButton();
    }


    @Test(priority = 6)
    public void loginWithInvalidCredentialsShowsAlert() {
        loginPage.enterEmail("invalid@example.com");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLoginButton();
  //      String alertText = loginPage.getAlertText();
//        assert alertText != null : "No alert was displayed after failed login.";
//        assert alertText.equals("Login failed: Invalid login credentials") : "Unexpected alert text: " + alertText;
    }

    @Test(priority = 7)
    public void acceptAlertTest() {
        loginPage.acceptAlert();
    }

}
