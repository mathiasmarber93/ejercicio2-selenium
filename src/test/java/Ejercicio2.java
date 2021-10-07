import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Ejercicio2 extends Base{

    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
        driver.get("https://demoqa.com/buttons");
    }

    @Test
    public void testDoubleClick(){
        Actions actions = new Actions(driver);
        WebElement doubleClickButton =  driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickButton).perform();
        System.out.println("TEST 1: Hiciste doble click");
    }

    @Test(dependsOnMethods = {"testDoubleClick"})
    public void testRightClick(){
        Actions actions = new Actions(driver);
        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickButton).perform();
        System.out.println("TEST 2: Hiciste click derecho");
    }

    @Test(dependsOnMethods = {"testDoubleClick", "testRightClick"})
    public void testDynamicClick(){
        WebElement clickButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/button"));
        clickButton.click();
        System.out.println("TEST 3: Hiciste click dinamico");
    }

    @Test(dataProvider = "getClickMessages", dependsOnMethods = {"testDoubleClick", "testRightClick", "testDynamicClick"})
    public void InformMessages(String ButtonType, String message){
        System.out.println("El tipo fue: " + ButtonType + " y el mensaje generado fue: " + message);
    }

    @DataProvider
    public Object[][] getClickMessages(){
        Object[][] data = new Object[3][2];

        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));

        //1st message
        data[0][0] = "+DOBLE CLIC+";
        data[0][1] = doubleClickMessage.getText();

        //2nd message
        data[1][0] = "+CLIC DERECHO+";
        data[1][1] = rightClickMessage.getText();

        //3rd message
        data[2][0] = "+CLIC DINAMICO+";
        data[2][1] = dynamicClickMessage.getText();

        return data;
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
