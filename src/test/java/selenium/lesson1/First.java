package selenium.lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        driver.navigate().to("https://www.epam.com");
        WebElement element = driver.findElement(By.cssSelector("button.hamburger-menu__button"));
        element.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('1')");
//        js.executeAsyncScript("alert('2')");
        driver.getWindowHandles();
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
