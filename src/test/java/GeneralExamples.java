import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GeneralExamples extends Base{
    @BeforeTest
    public void  initialize(){
        driver = initializeDriver();
    }

    @Test
    public void testGet() throws InterruptedException {
        driver.get("https://www.google.com");
        Thread.sleep(3000);
        driver.get("https://stackoverflow.com");
        Thread.sleep(3000);
        driver.get("https://rpp.pe");
        Thread.sleep(3000);
    }

    @Test
    public void testBackForward() throws InterruptedException{
        driver.get("https://www.google.com");
        Thread.sleep(3000);
        driver.get("https://stackoverflow.com");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
    }

    @Test
    public void testGetCurrentUrl() throws InterruptedException{
        String url;
        driver.get("https://www.google.com");
        url = driver.getCurrentUrl();
        System.out.println(url);
    }

    @Test
    public void getCurrentTitle(){
        String pageTitle;
        driver.get("https://www.google.com");
        pageTitle = driver.getTitle();
        System.out.println(pageTitle);
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
