package hw.hw4.base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;


public abstract class TestBase {

    @BeforeClass
    public void prepareDriver() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 6000;
        Configuration.collectionsPollingInterval = 300;
        Configuration.pollingInterval = 200;
    }
}
