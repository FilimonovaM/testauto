package hw.hw2.ex3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static java.lang.System.setProperty;

public class SeleniumTest {
    WebDriver driver;

    @BeforeSuite
    public void setMillis() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @BeforeTest(alwaysRun = true)
    public void prepareBrowser() {
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    @BeforeMethod
    public void getTitle() {
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void getMillis() {
        System.out.println(System.currentTimeMillis());
    }

    @AfterTest(alwaysRun = true)
    public void closeResources() {
        driver.close();
    }

    @AfterSuite
    public void doAfterEverything() {
        if (driver.toString().contains("null")) {
            driver.quit();
        }
    }

    @Test
    public void checkPageFunctionality() {
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(), "Index Page");
        WebElement logInForm = driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li"));
        logInForm.click();
        logInForm = driver.findElement(By.id("Login"));
        logInForm.sendKeys("epam");
        logInForm = driver.findElement(By.id("Password"));
        logInForm.sendKeys("1234");
        logInForm = driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/div/form/button"));
        logInForm.click();
        logInForm = driver
                .findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/a/div/span"));
        Assert.assertTrue(logInForm.isDisplayed());
        Assert.assertTrue(logInForm.getText().equalsIgnoreCase("PITER CHAILOVSKII"));
        Assert.assertEquals(driver.getTitle(), "Index Page");
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        Assert.assertEquals(images.size(), 4);
        images.forEach(list -> Assert.assertTrue(list.isDisplayed()));
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
