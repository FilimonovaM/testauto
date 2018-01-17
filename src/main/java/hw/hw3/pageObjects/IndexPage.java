package hw.hw3.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
}
