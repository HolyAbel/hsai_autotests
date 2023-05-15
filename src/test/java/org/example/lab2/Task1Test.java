package org.example.lab2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Task1Test extends DriverSetup {
    @Test
    public void softAssertTest() {
        //2. Assert Browser title
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        // 4. Assert Username is loggined
        softAssert.assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        String[] texts1 = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};

        List<WebElement> elements = driver.findElement(By.tagName("header")).
                findElement(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8")).
                findElements(By.xpath("./child::*"));

        for (int i = 0; i < elements.size(); i++) {
            softAssert.assertTrue(elements.get(i).isDisplayed());
            softAssert.assertEquals(elements.get(i).getText(), texts1[i]);
        }

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        //driver.findElement
        elements = driver.findElements(By.className("benefit-icon"));
        softAssert.assertEquals(elements.size(), 4);
        for (WebElement el : elements) {
            softAssert.assertTrue(el.isDisplayed());
        }

        //7. Assert that there are 4 texts on the Index
        //Page under icons and they have proper text
        String[] texts2 = {
                "To include good practices\n" + "and ideas from successful\n" + "EPAM project",
                "To be flexible and\n" + "customizable",
                "To be multiplatform",
                "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"
        };

        elements = driver.findElements(By.className("benefit-txt"));
        softAssert.assertEquals(elements.size(), 4);

        for (int i = 0; i < elements.size(); i++) {
            softAssert.assertEquals(elements.get(i).getText(), texts2[i]);
        }

        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertEquals(driver.findElement(By.tagName("iframe")).getAttribute("src"),
            "https://jdi-testing.github.io/jdi-light/frame-button.html");

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssert.assertEquals(driver.switchTo().frame("frame").
                        findElement(By.id("frame-button")).getAttribute("value"), "Frame Button");

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        String[] texts3 = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};

        elements = driver.findElement(By.cssSelector("ul.sidebar-menu.left")).
                findElements(By.xpath("./child::*"));

        softAssert.assertEquals(elements.size(), 5);

        for (int i = 0; i < elements.size(); i++) {
            softAssert.assertTrue(elements.get(i).isDisplayed());
            softAssert.assertEquals(elements.get(i).getText(), texts3[i]);
        }

        softAssert.assertAll();
    }
}
