package hw.hw4.ex2;

import com.codeborne.selenide.Selenide;
import enums.IndexPageEnum;
import hw.hw4.base.TestBase;
import hw.hw4.pageObjects.Dates;
import hw.hw4.pageObjects.IndexPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestDataPage extends TestBase {
    private IndexPage indexPage;
    private Dates dates;

    @BeforeMethod
    public void setPage() {
        indexPage = Selenide.page(IndexPage.class);
        dates = Selenide.page(Dates.class);
        indexPage.setDriver(getWebDriver());
    }

    @AfterMethod(alwaysRun = true)
    public void closeResources() {
        close();
    }

    //1 Create a new test in a new Java class, specify test name accordingly checking functionality
    // Test has a name accordingly checking functionality
    @Test
    public void checkPageFunctionality() {
        //2 Open test site by URL	https://jdi-framework.github.io/tests
        indexPage.openURL(IndexPageEnum.CURRENT_URL.text);

        //3 Perform login	username: epam, pass: 1234
        indexPage.login(IndexPageEnum.LOGIN.text, IndexPageEnum.PASSWORD.text);

        //4 Assert User name in the left-top side of screen that user is loggined	"
        // PITER CHAILOVSKII"	Name has displayed and equals to expected result
        indexPage.checkUser();

        //Open Service -> Dates
        indexPage.clickDates();

        //Using drag-and-drop set Range sliders. left sliders - the most left position,
        // right slider - the most rigth position	left - 0, right - 100	MAX range is set.
        // Check sliders values.	Assertion for sliders values must be implemented by 1 unified method
        dates.checkDragAndDrop(0, 100);
        //Using drag-and-drop set Range sliders. left sliders - the most left position, right slider -
        // the most left position.	left - 0, right - 0 MIN-left range is set
        dates.checkDragAndDrop(0, null);
        //Using drag-and-drop set Range sliders. left sliders - the most right position,
        // right slider - the most right position.	 left - 0, right - 0	MIN-right range is set
        dates.checkDragAndDrop(null, 0);
        //Using drag-and-drop set Range sliders.	left - 30, right - 70	Range is set. Check sliders values.
        dates.checkDragAndDrop(30, 70);
    }
}