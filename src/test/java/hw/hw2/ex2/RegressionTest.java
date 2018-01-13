package hw.hw2.ex2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegressionTest {

    @Test(groups = "regression")
    public void test1() {
        Assert.assertEquals(1, 1);
    }

    @Test(groups = "regression")
    public void test2() {
        Assert.assertEquals(2, 2);
    }

    @Test(groups = "regression")
    public void test3() {
        Assert.assertEquals(3, 3);
    }

    @Test(groups = "regression")
    public void test4() {
        Assert.assertEquals(4, 4);
    }
}
