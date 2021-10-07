import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample4 extends Base{

    @BeforeTest(alwaysRun = true)
    public void initialize(){
        driver = initializeDriver();
    }

    @Test(groups = {"work", "salesforce"})
    public void testExample4_1(){
        driver.get("https://www.google.com");
        System.out.println("abrimos google");
    }

    @Test(groups = {"work", "hire"})
    public void testExample4_2(){
        driver.get("https://www.linkedin.com");
        System.out.println("abrimos linkedin");
    }
    //Se deberia exlucir el 3er metodo
    @Test(groups = {"crm", "salesforce"})
    public void testExample4_3(){
        driver.get("https://www.salesforce.com");
        System.out.println("abrimos salesforce");
    }

    @AfterTest(alwaysRun = true)
    public void closeDriver(){
        driver.close();
    }
}
