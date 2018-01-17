package testNg.lesson2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Second {

    //    @Test(invocationCount = 3, threadPoolSize = 3)
    @Test
    public void simpleTest1() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.epam.com");
        WebElement element = driver.findElement(By.cssSelector("button.hamburger-menu__button"));
        element.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('1')");
        driver.getWindowHandles();
        driver.close();
    }
}
