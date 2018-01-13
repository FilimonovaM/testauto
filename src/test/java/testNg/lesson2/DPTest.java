package testNg.lesson2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPTest {

    @DataProvider
    public Object[][] dp(){
        return new Object[][]{
                {1, "Vasya"},
                {2, "Petya"}
        };
    }
    @Test(dataProvider = "dp")
    public void dpTest(int i, String s) {
        System.out.println("int: "+i+"\tString: "+s);
    }
}
