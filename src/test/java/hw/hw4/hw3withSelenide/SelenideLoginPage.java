package hw.hw4.hw3withSelenide;

import com.codeborne.selenide.Selenide;
import hw.hw4.base.TestBase;
import hw.hw4.pageObjects.IndexPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static enums.IndexPageEnum.*;

public class SelenideLoginPage extends TestBase {
    private IndexPage indexPage;

    @BeforeMethod
    public void setPage() {
        indexPage = Selenide.page(IndexPage.class);
    }

    //10 Close Browser
    @AfterMethod(alwaysRun = true)
    public void closeResources() {
        close();
    }

    //1 Create a new test in a new Java class, specify test name in accordance with checking functionality
    @Test
    public void checkPageFunctionality() {

        //2 Open test site by URL
        indexPage.openURL(CURRENT_URL.text);

        //3 Assert Browser title
        indexPage.checkTitle();

        //4 Perform login
        indexPage.login(LOGIN.text, PASSWORD.text);

        //5 Assert User name in the left-top side of screen that user is logged
        indexPage.checkUser();

        //6 Assert Browser title
        indexPage.checkTitle();

        //7 Assert that there are 4 images on the Home Page and they are displayed
        indexPage.checkImages();

        //8 Assert that there are 4 texts on the Home Page and check them by getting texts
        indexPage.checkTextsUnderImages();

        //9 Assert that there are the main header and the text below it on the Home Page
        indexPage.checkCentralTexts();
    }
}
