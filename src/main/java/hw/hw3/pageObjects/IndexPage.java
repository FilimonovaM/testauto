package hw.hw3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static enums.IndexPageEnum.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {

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

    public void openURL(String url, WebDriver driver) {
        driver.navigate().to(url);
    }

    public void checkTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), TITLE.text);
    }

    public void checkUser() {
        assertTrue(userName.isDisplayed());
        assertTrue(userName.getText().equalsIgnoreCase(USER_NAME.text));
    }

    public void checkImages() {
        assertEquals(images.size(), 4);
        images.forEach(list -> assertTrue(list.isDisplayed()));
    }

    public void checkTextsUnderImages() {
        texts.forEach((list -> assertTrue(list.isDisplayed())));
        assertEquals(texts.size(), 4);
        for (int i = 0; i < texts.size(); i++) {
            assertEquals(texts.get(i).getText().replaceAll("\n", ""),
                    getExpectedText().get(i));
        }
    }

    public void checkPageContent() {
        assertEquals(headline.getText(), TEXT_HEADER.text);
        assertTrue(headline.isDisplayed());

        assertEquals(textBelowHeadline.getText(),
                TEXT_CONTENT.text);
        assertTrue(headline.isDisplayed());
    }
}
