package org.example.lab2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;


public class Task2Test extends DriverSetup {
    @Test(priority = 1)
    public void testHomePageTitle() {
        //2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");
    }

    @Test(priority = 2)
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
        checkboxes.stream().filter(checkbox -> checkbox.getText().equals("Water")).forEach(WebElement::click);
        checkboxes.stream().filter(checkbox -> checkbox.getText().equals("Wind")).forEach(WebElement::click);

        // 7. Select radio
        List<WebElement> radios = driver.findElements(By.className("label-radio"));
        radios.stream().filter(radio -> radio.getText().equals("Selen")).forEach(WebElement::click);

        // 8. Select in dropdown
        List<WebElement> selectors = driver.findElements(By.tagName("option"));
        selectors.stream().filter(selector -> selector.getText().equals("Yellow")).forEach(WebElement::click);

        // 9. Assert logs
        List<String> logs = driver.findElements(By.cssSelector("ul[class='panel-body-list logs'] > li")).
                stream().map(s -> s.getText().substring(9)).collect(Collectors.toList());

        List<String> expectedLogs = List.of(
                "Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true");

        assertEquals(logs, expectedLogs);
    }
}
