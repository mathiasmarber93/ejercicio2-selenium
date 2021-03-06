import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGExample7 extends Base{

    @Test
    @Parameters({"myName", "myAge", "suiteParameter"})
    public void testExample7_1(String myName, String myAge, String suiteParameter){
        System.out.println("test 7.1");
        System.out.println("My name is: " + myName);
        System.out.println("My age is: " + myAge);
        System.out.println(suiteParameter);
    }

    @Test
    @Parameters({"myUniversity", "myPC", "suiteParameter"})
    public void testExample7_2(String myUniversity, String myPC, String suiteParameter){
        System.out.println("test 7.2");
        System.out.println("My university is: " + myUniversity);
        System.out.println("My pc is: " + myPC);
        System.out.println(suiteParameter);
    }

    @Test(dataProvider = "getData")
    public void InformData(String username, String password){
        System.out.println("username: " + username);
        System.out.println("password: " + password);
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[3][2];

        //1st set
        data[0][0] = "firstUsername";
        data[0][1] = "firstPassword";

        //2nd set
        data[1][0] = "secondUsername";
        data[1][1] = "secondPassword";

        //3rd set
        data[2][0] = "thirdUsername";
        data[2][1] = "thirdPassword";

        return data;
    }
}
