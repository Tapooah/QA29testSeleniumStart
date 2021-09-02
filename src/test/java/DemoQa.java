import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoQa {

    WebDriver wd;

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://demoqa.com/automation-practice-form");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void fillStudentForm() {
        type(By.id("firstName"), "Ololo");
        type(By.cssSelector("#lastName"), "Tester");
        type(By.xpath("//*[@id='userEmail']"), "ololo_tester@gmail.com");
        wd.findElement(By.xpath("//label[normalize-space()='Female']")).click();
//        CW with error
//        wd.findElement(By.cssSelector("#gender-radio-1")).click();
        type(By.id("userNumber"), "1234567890");
        type(By.xpath("//*[@id='dateOfBirthInput']"), "3 Sep 2021");

        wd.findElement(By.id("close-fixedban")).click();
        wd.findElement(By.id("submit")).click();


    }

    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

}
