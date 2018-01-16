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
    private WebDriver driver;

    @BeforeSuite
    public void loadSuit() {
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
        //2 Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");

        //3 Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Index Page");

        //4 Perform login
        driver.findElement(By.cssSelector(".uui-profile-menu .dropdown-toggle")).click();
        driver.findElement(By.cssSelector("#Login")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".btn-login")).click();

        //5 Assert User name in the left-top side of screen that user is logged
        WebElement logInForm = driver
                .findElement(By.cssSelector(".profile-photo>span"));
        Assert.assertTrue(logInForm.isDisplayed());
        Assert.assertTrue(logInForm.getText().equalsIgnoreCase("PITER CHAILOVSKII"));

        //6 Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Index Page");

        //7 Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon"));
        Assert.assertEquals(images.size(), 4);
        images.forEach(list -> Assert.assertTrue(list.isDisplayed()));

        //8 Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> texts = driver.findElements(By.cssSelector(".benefit-txt"));
        texts.forEach((list -> Assert.assertTrue(list.isDisplayed())));
        Assert.assertEquals(texts.size(), 4);
        String[] messages = {"To include good practicesand ideas from successfulEPAM projec",
                "To be flexible andcustomizable",
                "To be multiplatform",
                "Already have good base(about 20 internal andsome external projects),wish to get more…"};
        for (int i = 0; i < messages.length; i++) {
            Assert.assertEquals(texts.get(i).getText().replaceAll("\n", ""), messages[i]);
        }

        //9 Assert that there are the main header and the text below it on the Home Page
        WebElement textElement = driver.findElement(By.cssSelector(".main-title.text-center"));
        Assert.assertEquals(textElement.getText(), "EPAM FRAMEWORK WISHES…");
        Assert.assertTrue(textElement.isDisplayed());
        textElement = driver.findElement(By.cssSelector(".main-txt.text-center"));
        Assert.assertEquals(textElement.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING " +
                "ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE " +
                "IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
        Assert.assertTrue(textElement.isDisplayed());
    }
}
