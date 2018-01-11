package unit1.hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckFunctions {
    WebDriver driver;

    @BeforeMethod
    public void prepareBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    @Test
    public void checkBrowserTitle() {
        Assert.assertEquals(driver.getTitle(), "Index Page");
        WebElement logInForm = driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li"));
        logInForm.click();
        logInForm = driver.findElement(By.id("Login"));
        logInForm.sendKeys("epam");
        logInForm = driver.findElement(By.id("Password"));
        logInForm.sendKeys("1234");
        logInForm = driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/div/form/button"));
        logInForm.click();
        Assert.assertEquals("", driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li")));
    }

    @AfterMethod
    public void closeResources() {
//        driver.close();
    }
}
