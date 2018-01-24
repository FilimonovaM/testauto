package hw.hw4.ex2;

import com.codeborne.selenide.Selenide;
import enums.IndexPageEnum;
import hw.hw4.base.TestBase;
import hw.hw4.pageObjects.Dates;
import hw.hw4.pageObjects.IndexPage;
import listeners.AllureAttachmentListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Selenide.close;

@Listeners(AllureAttachmentListener.class)
@Features({"Selenide Test Suite"})
@Stories({"\"Dates\" tests"})
public class TestDatesPage extends TestBase {
    private IndexPage indexPage;
    private Dates dates;

    @BeforeMethod
    public void setPage() {
        indexPage = Selenide.page(IndexPage.class);
        dates = Selenide.page(Dates.class);
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
        // right slider - the most rigth position	left - 0, right - 100
        // Check sliders values.	Assertion for sliders values must be implemented by 1 unified method
        dates.checkDragAndDrop(0, 100);

        //Using drag-and-drop set Range sliders. left sliders - the most left position, right slider -
        // the most left position.	left - 0, right - 0
        dates.checkDragAndDrop(0, 0);

        //Using drag-and-drop set Range sliders. left sliders - the most right position,
        // right slider - the most right position.	 left - 100, right - 100
        dates.checkDragAndDrop(100, 100);

        //Using drag-and-drop set Range sliders.	left - 30, right - 70
        dates.checkDragAndDrop(30, 70);
    }
}
