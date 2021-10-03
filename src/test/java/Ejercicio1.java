import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static utilities.RandomEmail.randomEmail;

public class Ejercicio1 extends Base{
    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void completeForm() throws InterruptedException{

        WebElement img_logo = driver.findElement(By.xpath("//*[@id=\"app\"]/header/a/img"));

        if(img_logo.isDisplayed()){
            WebElement firstname = driver.findElement(By.id("firstName"));
            firstname.sendKeys("Mathias");

            WebElement lastname = driver.findElement(By.id("lastName"));
            lastname.sendKeys("Martinez");

            WebElement email = driver.findElement(By.id("userEmail"));
            email.sendKeys(randomEmail());

            WebElement radiobtn = driver.findElement((By.id("gender-radio-1")));
            Actions action_radiobtn = new Actions(driver);
            action_radiobtn.moveToElement(radiobtn).click().perform();

            WebElement telephone = driver.findElement(By.id("userNumber"));
            telephone.sendKeys("9446583381");

            WebElement dateOfBirthday = driver.findElement(By.id("dateOfBirthInput"));
            dateOfBirthday.click();

            Select selectYear = new Select(driver.findElement(By.className("react-datepicker__year-select")));
            selectYear.selectByValue("1993");

            Select selectMonth = new Select(driver.findElement(By.className("react-datepicker__month-select")));
            selectMonth.selectByValue("3");

            WebElement selectDay = driver.findElement(By.xpath("//div[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[2]/div/div[6]"));
            selectDay.click();

            WebElement subject = driver.findElement((By.id("subjectsInput")));
            subject.sendKeys("Computer Science");
            WebElement subjectOption = driver.findElement(By.xpath("//div[@id='react-select-2-option-0']"));
            subjectOption.click();

            WebElement hobbies = driver.findElement((By.id("hobbies-checkbox-3")));
            Actions action_hobbies = new Actions(driver);
            action_hobbies.moveToElement(hobbies).click().perform();

            WebElement uploadPicture = driver.findElement((By.id("uploadPicture")));
            uploadPicture.sendKeys("C:\\Users\\Matias\\Desktop\\img_avatar.png");

            WebElement address = driver.findElement((By.id("currentAddress")));
            address.sendKeys("Av. Lima Peru 147 - Barranco Lima");

            WebElement selectState = driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]/div[1]"));
            selectState.click();
            WebElement option_state = driver.findElement(By.xpath("//div[@id='react-select-3-option-2']"));
            option_state.click();

            WebElement selectCity = driver.findElement(By.xpath("//*[@id=\"city\"]/div/div[1]"));
            selectCity.click();
            WebElement option_city = driver.findElement(By.xpath("//div[@id='react-select-4-option-0']"));
            option_city.click();

            WebElement submit = driver.findElement(By.cssSelector("#submit"));
            Actions action_submit = new Actions(driver);
            action_submit.moveToElement(submit).click().perform();

            //VALIDAR POR TITULO DE MODAL
            String expectedModalTitle = "Thanks for submitting the form";
            WebElement modalTitle = driver.findElement(By.xpath("//*[@id=\"example-modal-sizes-title-lg\"]"));
            SoftAssert compareTitles = new SoftAssert();
            compareTitles.assertEquals(modalTitle, expectedModalTitle);

            String fullname = firstname.getAttribute("value") + " " + lastname.getAttribute("value");

            WebElement stateSelected = driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]/div[1]"));
            WebElement citySelected = driver.findElement(By.xpath("//*[@id=\"city\"]/div/div[1]/div[1]"));
            String stateCity = stateSelected.getText() + " " + citySelected.getText();

            WebElement subjectSelected = driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]/div[1]/div[1]"));

            System.out.println(":::DATOS VALIDADOS:::");
            System.out.println("NOMBRE Y APELLIDOS: " + fullname);
            System.out.println("CORREO ELECTRONICO: " + email.getAttribute("value"));
            System.out.println("TELEFONO: " + telephone.getAttribute("value"));
            System.out.println("FECHA DE NACIMIENTO: " + dateOfBirthday.getAttribute("value"));
            System.out.println("CARRERA: " + subjectSelected.getText());
            System.out.println("DIRECCION: " + address.getAttribute("value"));
            System.out.println("ESTADO Y CIUDAD: " + stateCity);

            System.out.println(":::SE REGISTRO EL FORMULARIO CON EXITO:::");
        } else {
            System.out.println("::::ERROR::::");
        }
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
