package hw.hw3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static enumPackage.IndexPageTextsEnum.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {
    private WebDriver driver;

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private WebElement loginFromButton;

    @FindBy(css = "#Login")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = ".btn-login")
    private WebElement submitButton;

    @FindBy(css = ".profile-photo>span")
    private WebElement userName;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> images;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> texts;

    @FindBy(css = ".main-title.text-center")
    private WebElement headline;

    @FindBy(css = ".main-txt.text-center")
    private WebElement textBelowHeadline;

    public void login(String name, String password) {
        loginFromButton.click();
        loginInput.sendKeys(name);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public WebElement getUserName() {
        return userName;
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getTexts() {
        return texts;
    }

    public WebElement getHeadline() {
        return headline;
    }

    public WebElement getTextBelowHeadline() {
        return textBelowHeadline;
    }

    public void openURL(String url, WebDriver driver) {
        driver.navigate().to(url);
        this.driver = driver;
    }

    public void checkTitle() {
        assertEquals(driver.getTitle(), TITLE.text);
    }

    public void checkUser() {
        assertTrue(getUserName().isDisplayed());
        assertTrue(getUserName().getText().equalsIgnoreCase(USER_NAME.text));
    }

    public void checkImages() {
        assertEquals(getImages().size(), 4);
        getImages().forEach(list -> assertTrue(list.isDisplayed()));
    }

    public void checkTextsUnderImages() {
        getTexts().forEach((list -> assertTrue(list.isDisplayed())));
        assertEquals(getTexts().size(), 4);
        for (int i = 0; i < getTexts().size(); i++) {
            assertEquals(getTexts().get(i).getText().replaceAll("\n", ""),
                    getExpectedText().get(i));
        }
    }

    public void checkPageContent() {
        assertEquals(getHeadline().getText(), TEXT_HEADER.text);
        assertTrue(getHeadline().isDisplayed());
        assertEquals(getTextBelowHeadline().getText(),
                TEXT_CONTENT.text);
        assertTrue(getTextBelowHeadline().isDisplayed());
    }
}
