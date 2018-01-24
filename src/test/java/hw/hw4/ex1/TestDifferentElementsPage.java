package hw.hw4.ex1;

import com.codeborne.selenide.Selenide;
import enums.DifferentElementEnum;
import hw.hw4.base.TestBase;
import hw.hw4.pageObjects.DifferentElement;
import hw.hw4.pageObjects.IndexPage;
import listeners.AllureAttachmentListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Selenide.close;
import static enums.IndexPageEnum.*;

@Listeners(AllureAttachmentListener.class)
@Features({"Selenide Test Suite"})
@Stories({"\"Different elements page\" tests"})
// 1   Create a new test in a new Java class, specify test name accordingly checking functionality
public class TestDifferentElementsPage extends TestBase {
    private IndexPage indexPage;
    private DifferentElement differentElement;

    @BeforeMethod
    public void setPage() {
        indexPage = Selenide.page(IndexPage.class);
        differentElement = Selenide.page(DifferentElement.class);
    }

    @AfterMethod(alwaysRun = true)
    public void closeResources() {
        close();
    }

    @Test
    public void checkPageFunctionality() {
        //2 Open test site by URL	https://jdi-framework.github.io/tests
        indexPage.openURL(CURRENT_URL.text);

        //3 Perform login	username: epam, pass: 1234	User has loggined
        indexPage.login(LOGIN.text, PASSWORD.text);

        //4 Assert User name in the left-top side of screen that user is loggined	"PITER CHAILOVSKII"
        indexPage.checkUser();

        //5 Check interface on Home page, it contains all needed elements.	4 - pictures, 4 texts under
        // them, 2 text above
        indexPage.checkIndexPageCentralContent();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        // "Support, Dates, Complex Table, Simple Table, Tables With Wages, Different Elements"
        indexPage.checkLeftServiceSubmenuCategories();

        //7 Click on "Service" subcategory in the header and check that drop down contains options
        // 	"Support, Dates, Complex Table, Simple Table, Tables With Wages, Different Elements"
        indexPage.checkHeaderServiceSubmenuCategories();

        //8 Open through the header menu Service -> Different Elements Page
        indexPage.clickDifferentElement();

        //Check interface on Service page, it contains all needed elements.
        // 4 - checkboxes, 4 radios, dropdown, 2 - buttons, left section, right section.
        differentElement.checkElements();

        //9 Select and assert checkboxes	Water, Wind	Elements are checked
        differentElement.checkSelectionOfElements();

        //10 Select radio	Selen	Element is checked
        differentElement.checkSelectionOfRadio();

        //11 Select in dropdown	Yellow	Element is selected
        differentElement.checkColorSelection();

        //12 Check in logs section selected values and status (true|false)	Water, Wind, Selen, Yellow	Rows exists
        differentElement.checkLogs(0, 4, DifferentElementEnum.LOG_1.text);

        //13 Unselect and assert checkboxes	Water, Wind	Elements are unchecked
        differentElement.checkUnselection();

        //Check in logs section unselected values and status (true|false)	Water, Wind	Rows exists
        differentElement.checkLogs(4, 6, DifferentElementEnum.LOG_2.text);
    }
}
