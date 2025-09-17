package Tests;

import org.testng.annotations.Test;

public class NdosiTests extends Base{

    @Test
    public void verifyHomePageIsDisplayedTests(){
        homePage.verifyHomePageIsDisplayed();
    }

}
