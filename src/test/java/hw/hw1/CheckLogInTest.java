package hw.hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckLogInTest {
    WebDriver driver;

    //1 Open test site by URL
    @BeforeMethod
    public void prepareBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    //10 Close Browser
    @AfterMethod(alwaysRun = true)
    public void closeResources() {
        driver.close();
    }

    //2 Create a new test in a new Java class, specify test name in accordance with checking functionality
    @Test
    public void checkPageFunctionality() {
        //3 Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Index Page");

        //4 Perform login
        WebElement logInForm = driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li"));
        logInForm.click();
        logInForm = driver.findElement(By.id("Login"));
        logInForm.sendKeys("epam");
        logInForm = driver.findElement(By.id("Password"));
        logInForm.sendKeys("1234");
        logInForm = driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/div/form/button"));
        logInForm.click();

        //5 Assert User name in the left-top side of screen that user is logged
        logInForm = driver
                .findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/a/div/span"));
        Assert.assertTrue(logInForm.isDisplayed());
        Assert.assertTrue(logInForm.getText().equalsIgnoreCase("PITER CHAILOVSKII"));

        //6 Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Index Page");

        //7 Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        Assert.assertEquals(images.size(), 4);
        images.forEach(list -> Assert.assertTrue(list.isDisplayed()));

        //8 Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        texts.forEach((list -> Assert.assertTrue(list.isDisplayed())));
        Assert.assertEquals(texts.size(), 4);
        String[] messages = {"To include good practices\nand ideas from successful\nEPAM projec",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};
        for (int i = 0; i < messages.length; i++) {
            Assert.assertEquals(texts.get(i).getText(), messages[i]);
        }

        //9 Assert that there are the main header and the text below it on the Home Page
        WebElement textElement = driver.findElement(By.cssSelector("h3.main-title.text-center"));
        Assert.assertEquals(textElement.getText(), "EPAM FRAMEWORK WISHES…");
        Assert.assertTrue(textElement.isDisplayed());
        textElement = driver.findElement(By.cssSelector("p.main-txt.text-center"));
        Assert.assertEquals(textElement.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING " +
                "ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE " +
                "IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
        Assert.assertTrue(textElement.isDisplayed());
    }
}
