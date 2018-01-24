package hw.hw4.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import enums.DifferentElementEnum;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static enums.DifferentElementEnum.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElement {

    @FindBy(css = ".label-checkbox")
    private List<SelenideElement> checkboxes;

    @FindBy(css = ".label-radio")
    private List<SelenideElement> radios;

    @FindBy(css = "select.uui-form-element")
    private SelenideElement dropdown;

    @FindBy(css = ".main-content .uui-button")
    private List<SelenideElement> buttons;

    @FindBy(css = "._mCS_1")
    private SelenideElement leftSection;

    @FindBy(css = "ul.panel-body-list.logs li")
    private List<SelenideElement> logs;


    @FindBy(css = "._mCS_2")
    private SelenideElement rightSection;

    private StringBuffer stringBuffer;
    private SelenideElement checkboxName;
    private SelenideElement selen;

    @Step
    public SelenideElement getCheckboxName(DifferentElementEnum element) {
        checkboxes.forEach(checkbox -> {
            if (checkbox.text().equalsIgnoreCase(element.text)) {
                checkboxName = checkbox;
            }
        });
        return checkboxName;
    }

    @Step
    public void checkElements() {
        assertEquals(checkboxes.size(), 4);
        checkboxes.forEach(checkbox -> checkbox.should(Condition.visible));

        assertEquals(radios.size(), 4);
        radios.forEach(radio -> radio.should(Condition.visible));

        assertTrue(dropdown.exists());
        dropdown.should(Condition.visible);

        assertEquals(buttons.size(), 2);
        buttons.forEach(button -> button.should(Condition.visible));

        assertTrue(leftSection.exists());
        leftSection.should(Condition.visible);

        assertTrue(rightSection.exists());
        rightSection.should(Condition.visible);
    }

    @Step
    public void checkSelectionOfElements(DifferentElementEnum... elementEnums) {
        for (DifferentElementEnum element : elementEnums) {
            getCheckboxName(element).click();
            getCheckboxName(element).find(INPUT.text).should(Condition.checked);
        }
    }

    @Step
    public void checkSelectionOfRadio() {
        radios.forEach(radio -> {
            if (radio.getText().equalsIgnoreCase(SELEN.text)) {
                selen = radio;
            }
        });
        selen.click();
        selen.find(INPUT.text).should(Condition.checked);
    }

    @Step
    public void checkColorSelection() {
        dropdown.click();
        dropdown.selectOption(YELLOW.text);
        dropdown.should(Condition.text(YELLOW.text));
    }

    public void checkLogs(int start, int end, boolean isExist, String... elements) {
        for (String element : elements) {
            boolean b = false;
            for (int i = start; i < end; i++) {
                if (logs.get(i).getText().replaceAll("[\\d\\s\\W]", "").toLowerCase().
                        startsWith(element.toLowerCase()) && logs.get(i).getText()
                        .replaceAll("[\\d\\s\\W]", "").toLowerCase()
                        .endsWith(String.valueOf(isExist))) {
                    b = true;
                    break;
                } else if (logs.get(i).getText().replaceAll("[\\d\\s\\W]", "")
                        .toLowerCase().startsWith(METALL.text)
                        || logs.get(i).getText().replaceAll("[\\d\\s\\W]", "")
                        .toLowerCase().startsWith(COLOR.text)) {
                    b = true;
                    break;
                } else {
                    b = false;
                }
            }
            assertTrue(b);
        }
    }

    @Step
    public void checkUnselection(DifferentElementEnum... elementEnums) {
        for (DifferentElementEnum element : elementEnums) {
            getCheckboxName(element).click();
            getCheckboxName(element).find(INPUT.text).shouldNot(Condition.checked);
        }
    }
}
