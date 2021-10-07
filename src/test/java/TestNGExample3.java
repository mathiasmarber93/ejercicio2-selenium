import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample3 extends Base{

    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
    }

    @Test(enabled = false)
    public void textExample3_1(){
        driver.get("https://www.google.com/");
        System.out.println("abrimos google");
    }

    @Test
    public void textExample3_2(){
        driver.get("https://www.amazon.com/");
        System.out.println("abrimos amazon");
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
