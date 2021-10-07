import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample1 extends Base{

    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
    }

    @Test
    public void testExamepl1_1(){
        driver.get("https://www.google.com/");
        System.out.println("abrimos google");
    }

    @Test
    public void testExamepl1_2(){
        driver.get("https://www.sony.com/");
        System.out.println("abrimos sony");
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }

}
