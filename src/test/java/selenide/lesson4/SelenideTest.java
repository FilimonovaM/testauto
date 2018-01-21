package selenide.lesson4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import training.base.BaseSelenide;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SelenideTest extends BaseSelenide {

    @AfterMethod
    public void closeResources() {
        close();
    }

    @Test()//(dependsOnMethods = "test2")h
    public void simpleTest1() {
        open("https://www.epam.com");
        Assert.assertEquals(getWebDriver().getTitle(), "EPAM | Software Product Development Services");

        $(".header-search__button").click();
        SelenideElement menuButton = $(".hamburger-menu__button");
        menuButton.click();

        $(".hamburger-menu__button").should(Condition.visible);
        menuButton.should(text("MENU"));
    }

    @Test()//(dependsOnMethods = "test2")h
    public void simpleTest2() {
        open("https://www.epam.com");
        Assert.assertEquals(getWebDriver().getTitle(), "EPAM | Software Product Development Services");

        $(".header-search__button").click();
        SelenideElement menuButton = $(".hamburger-menu__button");
        menuButton.click();

        $(".hamburger-menu__button").should(Condition.visible);
        menuButton.should(text("MENU"));
    }

    @Test()//(dependsOnMethods = "test2")h

    public void simpleTest3() {
        open("https://www.epam.com");
        Assert.assertEquals(getWebDriver().getTitle(), "EPAM | Software Product Development Services");

        $(".header-search__button").click();
        SelenideElement menuButton = $(".hamburger-menu__button");
        menuButton.click();

        $(".hamburger-menu__button").should(Condition.visible);
        menuButton.should(text("MENU"));
    }
}
