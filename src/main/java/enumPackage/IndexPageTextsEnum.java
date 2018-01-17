package enumPackage;

import java.util.ArrayList;
import java.util.List;

public enum IndexPageTextsEnum {

    CURRENT_URL("https://jdi-framework.github.io/tests/index.htm"),
    LOGIN("epam"),
    PASSWORD("1234"),
    TITLE("Index Page"),
    USER_NAME("PITER CHAILOVSKII"),
    TEXT_1("To include good practicesand ideas from successfulEPAM projec"),
    TEXT_2("To be flexible andcustomizable"),
    TEXT_3("To be multiplatform"),
    TEXT_4("Already have good base(about 20 internal andsome external projects),wish to get more…"),
    TEXT_HEADER("EPAM FRAMEWORK WISHES…"),
    TEXT_CONTENT("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING " +
            "ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
            "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE " +
            "IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

    public String text;
    private static List<String> texts= new ArrayList<>();

    IndexPageTextsEnum(String text) {
        this.text = text;
    }

    public static List<String> getExpectedText() {
        texts.add(TEXT_1.text);
        texts.add(TEXT_2.text);
        texts.add(TEXT_3.text);
        texts.add(TEXT_4.text);
        return texts;
    }
}
