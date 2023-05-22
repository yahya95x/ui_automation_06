package testng_knowledge;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _01_TestNG_Annotations {

    @BeforeMethod
    public void setUp(){
        System.out.println("All the set ups");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("All the post condition");
    }

    @Test(priority = 1)
    public void test1(){
        System.out.println("This is test 1");
    }

    @Test(priority = 2)
    public void test2(){
        System.out.println("Hello World");
    }

    @Test(priority = 3)
    public void test3(){
        System.out.println("abc");
    }

    @Test(priority = 4)
    public void test4(){
        System.out.println("ABC");
    }

}
