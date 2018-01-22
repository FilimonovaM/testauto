package training.base.pageObjectsLess5;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertEquals;

public class IndexPage {

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private SelenideElement loginFormButton;

    @FindBy(css = "#Login")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private SelenideElement submitButton;

    @Step
    public void open(WebDriver driver) {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    @Step
    public void login(String name, String password) {
        loginFormButton.should(visible);
        loginFormButton.click();

        loginInput.sendKeys(name);
        passordInput.sendKeys(password);
        submitButton.click();
    }

    @Step
    public void checkPageTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "");
    }
}
