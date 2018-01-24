package enums;

public enum DifferentElementEnum {
    URL_DIFFERENT_ELEMENTS_PAGE("https://jdi-framework.github.io/tests/page8.htm"),
    INPUT("Input"),
    WATER("Water"),
    WIND("Wind"),
    SELEN("Selen"),
    YELLOW("Yellow"),
    METALL("metall"),
    COLOR("color");

    public String text;

    DifferentElementEnum(String text) {
        this.text = text;
    }
}
