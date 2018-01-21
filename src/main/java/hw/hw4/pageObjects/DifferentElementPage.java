package hw.hw4.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static enums.DifferentElementsPageEnum.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementPage {

    private List<SelenideElement> checkboxes = $$(".label-checkbox");
    private SelenideElement waterCheckbox;
    private SelenideElement windCheckbox;
    private SelenideElement selen;
    private List<SelenideElement> radios = $$(".label-radio");
    private SelenideElement dropdown = $("select.uui-form-element");
    private List<SelenideElement> buttons = $$(".main-content .uui-button");
    private SelenideElement leftSection = $("._mCS_1");
    private List<SelenideElement> logs = $$("ul.panel-body-list.logs li");
    private SelenideElement rightSection = $("._mCS_2");
    private StringBuffer stringBuffer;

    public SelenideElement getWaterCheckbox() {
        checkboxes.forEach(checkbox -> {
            if (checkbox.text().equalsIgnoreCase(WATER.text)) {
                waterCheckbox = checkbox;
            }
        });
        return waterCheckbox;
    }

    public SelenideElement getWindCheckbox() {
        checkboxes.forEach(checkbox -> {
            if (checkbox.text().equalsIgnoreCase(WIND.text)) {
                windCheckbox = checkbox;
            }
        });
        return windCheckbox;
    }

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

    public void checkSelectionOfElements() {
        getWaterCheckbox().click();
        getWaterCheckbox().find(INPUT.text).should(Condition.checked);
        getWindCheckbox().click();
        getWindCheckbox().find(INPUT.text).should(Condition.checked);
    }

    public void checkSelectionOfRadio() {
        radios.forEach(radio -> {
            if (radio.getText().equalsIgnoreCase(SELEN.text)) {
                selen = radio;
            }
        });
        selen.click();
        selen.find(INPUT.text).should(Condition.checked);
    }

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

    public void checkUnselection() {
        getWaterCheckbox().click();
        getWaterCheckbox().find(INPUT.text).shouldNot(Condition.checked);
        getWindCheckbox().click();
        getWindCheckbox().find(INPUT.text).shouldNot(Condition.checked);
    }
}
