package enums;

public enum DifferentElementEnum {
    URL_DIFFERENT_ELEMENTS_PAGE("https://jdi-framework.github.io/tests/page8.htm"),
    INPUT("input"),
    WATER("water"),
    WIND("wind"),
    SELEN("selen"),
    YELLOW("Yellow"),
    LOG_1(" Colors value changed to Yellow metal value changed to Selen Wind condition changed to true Water " +
            "condition changed to true"),
    LOG_2(" Wind condition changed to true Water condition changed to true");

    public String text;

    DifferentElementEnum(String text) {
        this.text = text;
    }
}
