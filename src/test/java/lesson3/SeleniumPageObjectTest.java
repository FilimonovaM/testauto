package lesson3;

import hw.hw3.page_objects.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumPageObjectTest {
    private WebDriver driver;
    private IndexPage indexPage;

    @BeforeClass(alwaysRun = true)
    public void setUpPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    //Close Browser
    @AfterMethod(alwaysRun = true)
    public void closeResources() {
        driver.close();
    }

    @Test
    public void simpleTest1() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        indexPage.login("epam", "1234");
    }
}
