package hw.hw4.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.DatesEnum;
import enums.DifferentElementEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static enums.IndexPageEnum.*;
import static org.testng.Assert.assertEquals;

public class IndexPage {
    static private WebDriver webDriver;
    private List<String> serviceList;
    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private SelenideElement loginFromButton;
    @FindBy(css = "#Login")
    private SelenideElement loginInput;
    @FindBy(css = "#Password")
    private SelenideElement passwordInput;
    @FindBy(css = ".btn-login")
    private SelenideElement submitButton;
    @FindBy(css = ".profile-photo>span")
    private SelenideElement userName;
    @FindBy(css = ".benefit-icon")
    private List<SelenideElement> images;
    @FindBy(css = ".benefit-txt")
    private List<SelenideElement> texts;
    @FindBy(css = ".main-title.text-center")
    private SelenideElement headline;
    @FindBy(css = ".main-txt.text-center")
    private SelenideElement textBelowHeadline;
    @FindBy(css = ".sub-menu>a")
    private SelenideElement serviceLeftSubcategoryButton;
    @FindBy(css = ".sub-menu a")
    private List<SelenideElement> serviceLeftMenuCategories;
    @FindBy(css = ".dropdown-toggle")
    private SelenideElement serviceHeaderSubcategoryButton;
    @FindBy(css = "li.dropdown.open a")
    private List<SelenideElement> serviceHeaderMenuCategories;
    @FindBy(css = "[href='page8.htm']")
    private SelenideElement differentElementsButton;
    @FindBy(css = "[href='page4.htm']")
    private SelenideElement dataButton;

    public void setDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openURL(String url) {
        Selenide.open(url);
    }

    public void checkTitle() {
        assertEquals(webDriver.getTitle(), "Index Page");
    }

    public void login(String name, String password) {
        loginFromButton.click();
        loginInput.sendKeys(name);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkUser() {
        userName.should(Condition.visible);
        userName.should(Condition.text(USER_NAME.text));
    }

    public void checkImages() {
        assertEquals(images.size(), 4);
        images.forEach(list -> list.should(Condition.visible));
    }

    public void checkTextsUnderImages() {
        texts.forEach((list -> list.should(Condition.visible)));
        assertEquals(texts.size(), 4);
        for (int i = 0; i < texts.size(); i++) {
            assertEquals(texts.get(i).getText().replaceAll("\n", ""), getExpectedText().get(i));
        }
    }

    public void checkCentralTexts() {
        headline.should(Condition.text(TEXT_HEADER.text));
        headline.should(Condition.visible);
        textBelowHeadline.should(Condition.text(TEXT_CONTENT.text));
        textBelowHeadline.should(Condition.visible);
    }

    public void checkIndexPageCentralContent() {
        checkImages();
        checkTextsUnderImages();
        checkCentralTexts();
    }

    public void checkLeftServiceSubmenuCategories() {
        serviceLeftSubcategoryButton.should(Condition.visible);
        serviceLeftSubcategoryButton.click();
        serviceList = new ArrayList<>();
        serviceLeftMenuCategories.forEach(category -> {
            category.should(Condition.visible);
            serviceList.add(category.getText());
        });
        Assert.assertTrue(serviceList.containsAll(getExpectedServiceMenuCategories()));

    }

    public void checkHeaderServiceSubmenuCategories() {
        serviceHeaderSubcategoryButton.should(Condition.visible);
        serviceHeaderSubcategoryButton.click();
        serviceList = new ArrayList<>();
        serviceHeaderMenuCategories.forEach(category -> {
            category.should(Condition.visible);
            serviceList.add(category.getText());
        });
        Assert.assertTrue(serviceList.containsAll(getExpectedServiceMenuCategories()));
    }

    public void clickDifferentElement() {
        differentElementsButton.click();
        Assert.assertEquals(webDriver.getCurrentUrl(), DifferentElementEnum.URL_DIFFERENT_ELEMENTS_PAGE.text);
    }

    public void clickDates() {
        serviceHeaderSubcategoryButton.click();
        dataButton.click();
        Assert.assertEquals(webDriver.getCurrentUrl(), DatesEnum.DATES_URL.text);
    }
}
