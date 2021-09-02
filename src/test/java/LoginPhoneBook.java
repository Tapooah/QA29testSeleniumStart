import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPhoneBook {

    WebDriver wd;

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().window().maximize();
    }

    @Test
    public void loginTest() {
        //1. open login form
        WebElement logButton = wd.findElement(By.cssSelector("a[href='/login']"));
        logButton.click();

        //2. fill email
        type(By.cssSelector("[placeholder='Email']"), "ololo.tester@gmail.com");

        //3. fill pass
        type(By.cssSelector("[placeholder='Password']"), "Ololo_Tester123");
        //4. click login
        WebElement loginAfterType = wd.findElement(By.cssSelector("button:nth-child(4)"));
        loginAfterType.click();
    }


    @Test
    public void loginXpathTest() {
        //1. open login form
        WebElement logNavbar = wd.findElement(By.xpath("//*[@href='/login']"));
        logNavbar.click();
        //2. fill email
        type(By.xpath("//*[@placeholder='Email']"), "ololo_tester@gmail.com");
        //3. fill pass
        type(By.xpath("//*[@placeholder='Password']"), "Ololo_Tester123");
        //4. click login
        WebElement logButton = wd.findElement(By.xpath("//input[1]/following-sibling::button[1]"));
        logButton.click();

    }


    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

}
