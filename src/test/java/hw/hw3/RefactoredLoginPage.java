package hw.hw3;

import hw.hw3.page_objects.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static enums.IndexPageEnum.*;

public class RefactoredLoginPage {
    private WebDriver driver;
    private IndexPage indexPage;

    @BeforeClass
    public void prepareBrowser() {
        driver = new ChromeDriver();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
        driver.manage().window().maximize();

    }

    //10 Close Browser
    @AfterMethod(alwaysRun = true)
    public void closeResources() {
        driver.close();
    }

    //1 Create a new test in a new Java class, specify test name in accordance with checking functionality
    @Test
    public void checkPageFunctionality() {

        //2 Open test site by URL
        indexPage.openURL(CURRENT_URL.text, driver);

        //3 Assert Browser title
        indexPage.checkTitle(driver);

        //4 Perform login
        indexPage.login(LOGIN.text, PASSWORD.text);

        //5 Assert User name in the left-top side of screen that user is logged
        indexPage.checkUser();

        //6 Assert Browser title
        indexPage.checkTitle(driver);

        //7 Assert that there are 4 images on the Home Page and they are displayed

        indexPage.checkImages();

        //8 Assert that there are 4 texts on the Home Page and check them by getting texts
        indexPage.checkTextsUnderImages();

        //9 Assert that there are the main header and the text below it on the Home Page
        indexPage.checkPageContent();
    }
}
