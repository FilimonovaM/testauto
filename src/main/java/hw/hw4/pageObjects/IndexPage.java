package hw.hw4.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.DifferentElementsPageEnum;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static enums.IndexPageEnum.*;
import static org.testng.Assert.assertEquals;

public class IndexPage {
    static private WebDriver webDriver;
    private List<String> serviceList;
    private SelenideElement loginFromButton = $(".uui-profile-menu .dropdown-toggle");
    private SelenideElement loginInput = $("#Login");
    private SelenideElement passwordInput = $("#Password");
    private SelenideElement submitButton = $(".btn-login");
    private SelenideElement userName = $(".profile-photo>span");
    private List<SelenideElement> images = $$(".benefit-icon");
    private List<SelenideElement> texts = $$(".benefit-txt");
    private SelenideElement headline = $(".main-title.text-center");
    private SelenideElement textBelowHeadline = $(".main-txt.text-center");
    private SelenideElement serviceLeftSubcategoryButton = $(".sub-menu>a");
    private List<SelenideElement> serviceLeftMenuCategories = $$(".sub-menu a");
    private SelenideElement serviceHeaderSubcategoryButton = $(".dropdown-toggle");
    private List<SelenideElement> serviceHeaderMenuCategories = $$("li.dropdown.open a");
    private SelenideElement differentElementsButton = $("[href='page8.htm']");

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

    public void clickDifferentElements() {
        differentElementsButton.click();
        Assert.assertEquals(webDriver.getCurrentUrl(), DifferentElementsPageEnum.URL_DIFFERENT_ELEMENTS_PAGE.text);
    }
}
