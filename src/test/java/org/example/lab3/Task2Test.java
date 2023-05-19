package org.example.lab3;

import org.example.lab3.elementspage.DifferentElementsPage;
import org.example.lab3.expecteddata.ExpectedData;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task2Test extends DriverSetup {
    @Test(priority = 1)
    public void testHomePageTitle() {
        //System.out.println("testHomePageTitle start");
        //2. Assert Browser title
        assertEquals(homePage.getTitle(), ExpectedData.SITE_NAME);
    }

    @Test(priority = 2)
    public void testIsLoggined() {
        // 4. Assert Username is loggined
        assertEquals(homePage.getUserName(), ExpectedData.USERNAME);
    }

    @Test(priority = 3)
    public void testElements() {
        differentElementsPage = new DifferentElementsPage(driver);

        // 5. Open through the header menu Service -> Different Elements Page
        homePage.getHeader().clickServiceDropDown();
        homePage.getHeader().clickDifferentElements();

        // 6. Select checkboxes
        differentElementsPage.SelectCheckBox("Water");
        differentElementsPage.SelectCheckBox("Wind");

        // 7. Select radio
        differentElementsPage.SelectRadio("Selen");

        // 8. Select in dropdown
        differentElementsPage.SelectInDropdown("Yellow");

        // 9. Assert logs
        assertEquals(differentElementsPage.getLogs(), ExpectedData.LOGS);
    }
}
