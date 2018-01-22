package hw.hw4.pageObjects;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class Dates {
    private List<SelenideElement> nodes = $$("a.ui-slider-handle.ui-state-default.ui-corner-all");

    public void checkDragAndDrop(Integer left, Integer right) {
        if(left == null){
            left = 0;
        }
        if(right == null){
            right = 0;
        }
        actions().dragAndDropBy(nodes.get(0), -300, 0).build().perform();
        actions().dragAndDropBy(nodes.get(1), -300, 0).build().perform();
        actions().dragAndDropBy(nodes.get(0), (int) (274.167 / 100 * right - 1.8), 0).build().perform();
        actions().dragAndDropBy(nodes.get(1), (int) (274.167 / 100 * left - 1.8), 0).build().perform();
        nodes.get(0).shouldHave(exactText(String.valueOf(left)));
        nodes.get(1).shouldHave(exactText(String.valueOf(right)));
    }
}
