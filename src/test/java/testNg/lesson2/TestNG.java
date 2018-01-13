package testNg.lesson2;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestNG extends TestBase {
    //    @Test(groups = {"first"})
    @Test
    public void simpleTest1() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.epam.com");
        WebElement element = driver.findElement(By.cssSelector("button.hamburger-menu__button"));
        element.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('1')");
//        js.executeAsyncScript("alert('2')");
        driver.getWindowHandles();
    }
}
