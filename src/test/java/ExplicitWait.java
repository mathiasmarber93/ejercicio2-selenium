import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExplicitWait extends Base{

    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

    }

    @Test
    public void testElementBeClickeable(){
        WebElement btnEnable = driver.findElement(By.id("enable-button"));
        btnEnable.click();
        WebElement btnTest = driver.findElement(By.id("disable"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(btnTest));
        btnTest.click();
    }

    @Test
    public void testVisibility(){
        WebElement btnDisplay = driver.findElement(By.id("display-other-button"));

        btnDisplay.click();

        WebElement btntest = driver.findElement(By.id("hidden"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(btntest));
    }

    @Test
    public void ElementToBeSelected(){
        WebElement btnEnable = driver.findElement(By.id("checkbox"));
        btnEnable.click();
        WebElement checkbox = driver.findElement(By.id("ch"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeSelected(checkbox));
        System.out.println("Hello World");
    }

    @Test
    public void testTexToBePresent(){
        WebElement btnChangeText = driver.findElement(By.id("populate-text"));
        btnChangeText.click();
        WebElement lblDynamic = driver.findElement(By.id("h2"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(lblDynamic, "Selenium Webdriver"));
        System.out.println("Hello World");
    }

    @Test
    public void testAlertPresent(){
        WebElement btnEnable = driver.findElement(By.id("alert"));
        btnEnable.click();WebDriverWait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        System.out.println("Hello World");
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }

}
