package org.example.lab3;

import org.example.lab3.expecteddata.ExpectedData;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task1Test extends DriverSetup {
    @Test
    public void softAssertTest() {
        SoftAssert softAssert = new SoftAssert();

        //2. Assert Browser title
        softAssert.assertEquals(homePage.getTitle(), ExpectedData.SITE_NAME);

        // 4. Assert Username is loggined
        softAssert.assertEquals(homePage.getUserName(), ExpectedData.USERNAME);

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertEquals(homePage.getHeader().getItemSize(), ExpectedData.HEADER_DATA_SIZE);
        softAssert.assertEquals(homePage.getHeader().getItemsNames(), ExpectedData.HEADER_DATA_NAMES);
        homePage.getHeader().getItemsList().forEach(item ->
                {
                    softAssert.assertTrue(item.isDisplayed());
                }
        );

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(homePage.getIconsSize(), ExpectedData.ICONS_SIZE);
        homePage.getHeader().getItemsList().forEach(icon ->
                {
                    softAssert.assertTrue(icon.isDisplayed());
                }
        );

        // 7. Assert that there 4
        softAssert.assertEquals(homePage.getIconsTextSize(), ExpectedData.TEXT_UNDER_ICONS_SIZE);
        softAssert.assertEquals(homePage.getIconsText(), ExpectedData.TEXT_UNDER_ICONS);

        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(homePage.getFrame().isDisplayed());

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssert.assertTrue(homePage.getFrameButton().isDisplayed());

        // 10. Switch to original window back
        homePage.switchToDefault();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        softAssert.assertEquals(homePage.getLeftSection().getItemsSize(), ExpectedData.LEFT_SECTION_ITEMS_SIZE);
        softAssert.assertEquals(homePage.getLeftSection().getItemsNames(), ExpectedData.LEFT_SECTION_ITEMS_STRINGS);
        homePage.getLeftSection().getItemsList().forEach(item ->
                {
                    softAssert.assertTrue(item.isDisplayed());
                }
        );

        softAssert.assertAll();
    }
}
