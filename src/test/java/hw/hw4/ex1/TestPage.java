package hw.hw4.ex1;

import com.codeborne.selenide.Selenide;
import enums.DifferentElementsPageEnum;
import hw.hw4.base.TestBase;
import hw.hw4.pageObjects.DifferentElementPage;
import hw.hw4.pageObjects.IndexPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.IndexPageEnum.*;

// 1   Create a new test in a new Java class, specify test name accordingly checking functionality
public class TestPage extends TestBase {
    private IndexPage indexPage;
    private DifferentElementPage differentElementPage;

    @BeforeMethod
    public void setPage() {
        indexPage = Selenide.page(IndexPage.class);
        differentElementPage = Selenide.page(DifferentElementPage.class);
        indexPage.setDriver(getWebDriver());
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
        indexPage.clickDifferentElements();

        //Check interface on Service page, it contains all needed elements.
        // 4 - checkboxes, 4 radios, dropdown, 2 - buttons, left section, right section.
        differentElementPage.checkElements();

        //9 Select and assert checkboxes	Water, Wind	Elements are checked
        differentElementPage.checkSelectionOfElements();

        //10 Select radio	Selen	Element is checked
        differentElementPage.checkSelectionOfRadio();

        //11 Select in dropdown	Yellow	Element is selected
        differentElementPage.checkColorSelection();

        //12 Check in logs section selected values and status (true|false)	Water, Wind, Selen, Yellow	Rows exists
        differentElementPage.checkLogs(0, 4, DifferentElementsPageEnum.LOG_1.text);

        //13 Unselect and assert checkboxes	Water, Wind	Elements are unchecked
        differentElementPage.checkUnselection();

        //Check in logs section unselected values and status (true|false)	Water, Wind	Rows exists
        differentElementPage.checkLogs(4, 6, DifferentElementsPageEnum.LOG_2.text);
    }
}
