package org.example.lab3.pages.homepage;

import org.example.lab3.pages.homepage.elements.Header;
import org.example.lab3.pages.homepage.elements.IFrame;
import org.example.lab3.pages.homepage.elements.LeftSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    protected static WebDriver driver;

    private Header header;

    private LeftSection leftSection;
    @FindBy(css = "body > header > div > nav > ul.uui-navigation.navbar-nav.navbar-right > li > a > span")
    private WebElement loginDropDownButton;

    @FindBy(id = "name")
    private WebElement login;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(className = "benefit-icon")
    private List<WebElement> icons;

    @FindBy(className = "benefit-txt")
    private List<WebElement> iconsText;

    @FindBy(tagName = "iframe")
    private WebElement frame;

    public HomePage(WebDriver driver, String url) {
        this.driver = driver;

        this.header = new Header(this.driver);

        this.leftSection = new LeftSection(this.driver);

        // 1. Open test site by URL
        driver.navigate().to(url);

        PageFactory.initElements(this.driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUserName() {
        return userName.getText();
    }

    public Header getHeader() {
        return header;
    }

    public void performLogin(String loginName, String passwordString) {
        loginDropDownButton.click();
        login.sendKeys(loginName);
        password.sendKeys(passwordString);
        loginButton.click();
    }

    public List<WebElement> getIcons() {
        return icons;
    }

    public int getIconsSize() {
        return icons.size();
    }

    public List<String> getIconsText() {
        return iconsText.stream().map(WebElement::getText).toList();
    }

    public int getIconsTextSize() {
        return iconsText.size();
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getFrameButton() {
        return new IFrame(driver).getFrameButton();
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    public LeftSection getLeftSection() {
        return leftSection;
    }
}
