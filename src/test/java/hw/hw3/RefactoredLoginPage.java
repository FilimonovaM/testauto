package hw.hw3;

import hw.hw3.pageObjects.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RefactoredLoginPage {
    private WebDriver driver;
    private IndexPage indexPage;

    @BeforeClass
    public void prepareBrowser() {
        driver = new ChromeDriver();
        indexPage = PageFactory.initElements(driver, IndexPage.class);

    }

    //10 Close Browser
    @AfterMethod(alwaysRun = true)
    public void closeResources() {
        driver.close();
    }

    //1 Create a new test in a new Java class, specify test name in accordance with checking functionality
    @Test
    public void checkPageFunctionality() {
        driver.manage().window().maximize();

        //2 Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");

        //3 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //4 Perform login
        indexPage.login("epam", "1234");

        //5 Assert User name in the left-top side of screen that user is logged
        assertTrue(indexPage.getUserName().isDisplayed());
        assertTrue(indexPage.getUserName().getText().equalsIgnoreCase("PITER CHAILOVSKII"));

        //6 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //7 Assert that there are 4 images on the Home Page and they are displayed
        assertEquals(indexPage.getImages().size(), 4);
        indexPage.getImages().forEach(list -> assertTrue(list.isDisplayed()));

        //8 Assert that there are 4 texts on the Home Page and check them by getting texts
        indexPage.getTexts().forEach((list -> assertTrue(list.isDisplayed())));
        assertEquals(indexPage.getTexts().size(), 4);
        String[] messages = {"To include good practicesand ideas from successfulEPAM projec",
                "To be flexible andcustomizable",
                "To be multiplatform",
                "Already have good base(about 20 internal andsome external projects),wish to get more…"};
        for (int i = 0; i < messages.length; i++) {
            assertEquals(indexPage.getTexts().get(i).getText().replaceAll("\n", ""), messages[i]);
        }

        //9 Assert that there are the main header and the text below it on the Home Page
        assertEquals(indexPage.getHeadline().getText(), "EPAM FRAMEWORK WISHES…");
        assertTrue(indexPage.getHeadline().isDisplayed());
        assertEquals(indexPage.getTextBelowHeadline().getText(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING " +
                "ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE " +
                "IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
        assertTrue(indexPage.getTextBelowHeadline().isDisplayed());
    }
}
