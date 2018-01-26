package hw.hw4.page_objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utile.Utile;

import java.util.List;

import static com.codeborne.selenide.Selenide.actions;

public class Dates {

    @FindBy(css = "a.ui-slider-handle.ui-state-default.ui-corner-all")
    private List<SelenideElement> nodes;

    @Step
    public void checkDragAndDrop(int left, int right) {
        actions().dragAndDropBy(nodes.get(0), -1000, 0).build().perform();
        actions().dragAndDropBy(nodes.get(1), 1000, 0).build().perform();

        double scrollPanelLength = nodes.get(1).getLocation().getX() - nodes.get(0).getLocation().getX();
        double step = scrollPanelLength / 100;

        actions().dragAndDropBy(nodes.get(0), (int) (left * step - ((left > 0) ? 0.5 * step : step)), 0).build()
                .perform();
        actions().dragAndDropBy(nodes.get(1), (int) (-((100 - right) * step + step)), 0).build().perform();

        Assert.assertEquals(Utile.makeInt(nodes.get(0).getText()), left);
        Assert.assertEquals(Utile.makeInt(nodes.get(1).getText()), right);
    }
}