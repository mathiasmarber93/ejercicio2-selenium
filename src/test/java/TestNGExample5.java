import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample5 extends Base{

    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
    }

    @Test
    public void testExample5_1(){
        driver.get("https://www.google.com");
        System.out.println("abrimos google");
    }

    @Test(dependsOnMethods = {"testExample5_1"})
    public void testExample5_2(){
        driver.get("https://www.linkedin.com");
        System.out.println("abrimos linkedin");
    }

    @Test(dependsOnMethods = {"testExample5_1", "testExample5_2"})
    public void testExample5_3(){
        driver.get("https://www.salesforce.com");
        System.out.println("abrimos salesforce");
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
