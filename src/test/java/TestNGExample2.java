import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample2 extends Base{
    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
    }

    @Test
    public void testExameple2_1(){
        driver.get("https://stackoverflow.com/");
        System.out.println("https://stackoverflow.com/");
    }

    @Test
    public void testExameple2_2(){
        driver.get("https://www.mi.com/global");
        System.out.println("abrimos xiaomi");
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
