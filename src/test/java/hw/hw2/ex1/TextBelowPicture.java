package hw.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TextBelowPicture {//
    private WebDriver driver;
    private String[] expected = {
            "To include good practices\n" +
                    "and ideas from successful\n" +
                    "EPAM projec",
            "To be flexible and\n" +
                    "customizable",
            "To be multiplatform",
            "Already have good base\n" +
                    "(about 20 internal and\n" +
                    "some external projects),\n" +
                    "wish to get more…"};

    @BeforeTest(alwaysRun = true)
    public void prepareBrowser() {
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        driver.manage().window().maximize();

    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        if (driver != null) {
            driver.close();
        }
    }

    @DataProvider(parallel = true)
    public Object[][] dp() {
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        Object[][] obj = new Object[texts.size()][2];
        for (int i = 0; i < texts.size(); i++) {
            for (int j = 0; j < 2; j++) {
                obj[i][j] = (j == 0) ? texts.get(i).getText() : expected[i];
            }
        }
        return obj;
    }

    @Test(dataProvider = "dp")
    public void dpTest(String actualValue, String expectedValue) {
        assertEquals(actualValue, expectedValue);
    }
}
