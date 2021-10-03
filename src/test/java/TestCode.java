import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCode extends Base{
    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
        driver.get("https://courses.letskodeit.com/practice");
    }

    @Test
    public void testVerify(){
        String actualTitle;
        String expectedTitle1 = "Practice Page";
        String expectedTitle2 = "TitleExample";

  /*      String actualURL;
        String expectedURL1 = "https://courses.letskodeit.com/practice";
        String expectedURL2 = "https://www.google.com";*/

        actualTitle = driver.getTitle();
        /*actualURL = driver.getCurrentUrl();*/

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedTitle1,actualTitle); //correcta
        softAssert.assertNotEquals(actualTitle,expectedTitle2); //correcto

     /*   softAssert.assertEquals(actualURL, expectedURL1);
        softAssert.assertEquals(actualURL, expectedURL2);*/

        System.out.println("Hola mundo");
        softAssert.assertAll();
    }

    @Test
    public void testHardAssert(){
        String actualTitle;
        String expectedTitle1 = "Practice Page";
        String expectedTitle2 = "TitleExample";

        String actualURL;
        String expectedURL1 = "https://courses.letskodeit.com/practice";
        String expectedURL2 = "https://www.google.com";

        actualTitle = driver.getTitle();
        actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedTitle1,actualTitle); //correcta
        Assert.assertNotEquals(actualTitle,expectedTitle2); //correcto

        System.out.println("Hola mundo");

    }

}
