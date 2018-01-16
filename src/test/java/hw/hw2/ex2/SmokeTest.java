package hw.hw2.ex2;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SmokeTest {

    @Test(groups = "smoke")
    public void test1() {
        assertEquals(1, 1);
    }

    @Test(groups = "smoke")
    public void test2() {
        assertEquals(2, 2);
    }

    @Test(groups = "smoke")
    public void test3() {
        assertEquals(3, 3);
    }

    @Test(groups = "smoke")
    public void test4() {
        assertEquals(4, 4);
    }
}
