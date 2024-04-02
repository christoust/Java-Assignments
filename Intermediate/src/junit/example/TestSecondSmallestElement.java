package junit.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestSecondSmallestElement {

    private static SecondSmallestElement secondSmallestElement= null;
    @BeforeAll
    public static void init()
    {
        System.out.println("Init method invoked");
        secondSmallestElement=new SecondSmallestElement();
    }
    @AfterAll
    public static void destroy()
    {
        System.out.println("Destroy method invoked");
        secondSmallestElement=null;
    }
    @Test
    void TestSecondSmallestElement1()
    {
        int [] input = {1,2,4,5,-9};
        int result = secondSmallestElement.getSecondSmallestElement(input);
        Assertions.assertEquals(1,result);
    }

    @Test
    void TestSecondSmallestElement2()
    {
        int [] input = {1};
        Assertions.assertThrows(NullPointerException.class,()->secondSmallestElement.getSecondSmallestElement(input));
    }
}
