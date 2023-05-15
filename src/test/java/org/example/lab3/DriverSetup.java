package org.example.lab3;

import org.example.lab3.differentelementspage.DifferentElementsPage;
import org.example.lab3.pages.homepage.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class DriverSetup {
    protected static WebDriver driver;
    public static HomePage homePage;

    public static DifferentElementsPage differentElementsPage;

    @BeforeTest
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saint Abel\\Desktop\\lab2_autotests\\hsai_autotests\\src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Path.of("src/test/resources/log-data.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver, properties.getProperty("site.url"));

        // 3. Perform login
        homePage.performLogin(properties.getProperty("user.login"), properties.getProperty("user.password"));
    }

    @AfterTest
    public static void quit() {
        driver.close();
    }

    public static void main(String[] args) {
        setup();
    }
}

