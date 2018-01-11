import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;

public class First {

    @Test//(dependsOnMethods = "test2")h
    public void simpleTest1() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();//TODO: загуглить про driver.timeouts()
//        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.MILLISECONDS);
        driver.navigate().to("https://www.epam.com");
        //       JavascriptExecutor js = (JavascriptExecutor) driver;
        //     js.executeScript("jjj");
        //   js.executeAsyncScript("alert('fjfjsksjs')");
//        driver.getWindowHandles();
//        WebElement element = driver.findElement(By.id("button__content button__content--desktop"));
        //дома покликать всякое

        driver.close();
    }

    @Test
    public void simpleTest2() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
        driver.close();
    }
}
