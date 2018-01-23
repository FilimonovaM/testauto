package hw.hw4.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
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
    private SelenideElement waterCheckbox;
    private SelenideElement windCheckbox;
    private SelenideElement selen;

    @Step
    public SelenideElement getWaterCheckbox() {
        checkboxes.forEach(checkbox -> {
            if (checkbox.text().equalsIgnoreCase(WATER.text)) {
                waterCheckbox = checkbox;
            }
        });
        return waterCheckbox;
    }

    @Step
    public SelenideElement getWindCheckbox() {
        checkboxes.forEach(checkbox -> {
            if (checkbox.text().equalsIgnoreCase(WIND.text)) {
                windCheckbox = checkbox;
            }
        });
        return windCheckbox;
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
        Assert.assertTrue(leftSection.exists());
        leftSection.should(Condition.visible);
        Assert.assertTrue(rightSection.exists());
        rightSection.should(Condition.visible);

    }

    @Step
    public void checkSelectionOfElements() {
        getWaterCheckbox().click();
        getWaterCheckbox().find(INPUT.text).should(Condition.checked);
        getWindCheckbox().click();
        getWindCheckbox().find(INPUT.text).should(Condition.checked);
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

    public void checkLogs(int start, int end, String log) {
        stringBuffer = new StringBuffer();
        for (int i = start; i < end; i++) {
            stringBuffer.append(logs.get(i).getText().replaceAll("[0-9:]", ""));
        }
        Assert.assertEquals(stringBuffer.toString(), log);
    }

    @Step
    public void checkUnselection() {
        getWaterCheckbox().click();
        getWaterCheckbox().find(INPUT.text).shouldNot(Condition.checked);
        getWindCheckbox().click();
        getWindCheckbox().find(INPUT.text).shouldNot(Condition.checked);
    }
}
