package org.example.lab2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class DriverSetup {
    protected static WebDriver driver;

    @BeforeTest
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saint Abel\\Desktop\\lab2_autotests\\hsai_autotests\\src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Open test site by URL
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 3. Perform login
        driver.findElements(By.className("dropdown-toggle")).get(1).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
    }

    @AfterTest
    public static void quit() {
        driver.close();
    }

    public static void main(String[] args) {
        setup();
    }
}

