package org.example.lab2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class Task2Test extends DriverSetup {
    @Test(priority = 1)
    public void testHomePageTitle() {
        //2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");
    }

    @Test(priority = 1)
    public void testIsLoggined() {
        // 4. Assert Username is loggined
        assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");
    }

    @Test(priority = 3)
    public void testElements() {
        // 5. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.className("dropdown-toggle")).click();
        driver.findElement(By.className("dropdown-menu")).
                findElements(By.xpath("./child::*")).
                get(7).findElement(By.tagName("a")).click();

        // 6. Select checkboxes
        List<WebElement> checkboxes = driver.findElements(By.className("label-checkbox"));
        for (WebElement cb : checkboxes) {
            if (cb.getText().equals("Water") || cb.getText().equals("Wind")) {
                cb.findElement(By.tagName("input")).click();
            }
        }

        // 7. Select radio
        List<WebElement> radios = driver.findElements(By.className("label-radio"));
        for (WebElement radio : radios) {
            if (radio.getText().equals("Selen")) {
                radio.findElement(By.tagName("input")).click();
            }
        }

        // 8. Select in dropdown
        List<WebElement> selectors = driver.findElements(By.tagName("option"));
        for (WebElement selector : selectors) {
            if (selector.getText().equals("Yellow")) {
                selector.click();
            }
        }

        // 9. Assert logs
        List<String> logs = driver.findElements(By.cssSelector("ul[class='panel-body-list logs'] > li")).
                stream().map(s -> s.getText().substring(9)).collect(Collectors.toList());

        String[] expectedLogs = new String[]{
                "Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true"
        };

        for (int i = 0; i < logs.size(); i++) {
            Assert.assertEquals(logs.get(i), expectedLogs[i]);
        }
    }
}
