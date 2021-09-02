import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class StartSelenium {

    //before [ open www ] ---> test [ steps ] + Assert ---> after [ logout ]

    // before [ open browser ] ---> test [ open www ] ---> after [ close www + browser ]
    WebDriver wd;


    //method "before"
    @BeforeMethod
    public void preCondition() {
        //open browser
        wd = new ChromeDriver();
    }

    //method "test"
    @Test
    public void startContact() {
        //open www

        //this get without history
        //wd.get("https://contacts-app.tobbymarshall815.vercel.app/home");

        //this get with history (can "forward", "back", "home", "refresh")
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");

        WebElement element1 = wd.findElement(By.tagName("div"));
        wd.findElement(By.cssSelector("div"));
        wd.findElement(By.xpath("//div"));

        List<WebElement> list = wd.findElements(By.tagName("div"));

        WebElement element2 = wd.findElement(By.id("root"));
        wd.findElement(By.cssSelector("#root"));
        wd.findElement(By.xpath("//*[@id='root]"));


        WebElement element3 = wd.findElement(By.className("login_login__3EHKB"));
        WebElement element = wd.findElement(By.cssSelector(".login_login__3EHKB"));
        wd.findElement(By.cssSelector(".container"));
        wd.findElement(By.xpath("//*[@class='container']"));
    }

    @Test
    public void loginTest() {
        //step1 = open www
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");

        //step2 = click login button
//        WebElement loginAnchor = wd.findElement(By.className("active"));
        WebElement loginAnchor = wd.findElement(By.linkText("LOGIN"));
        loginAnchor.click();

        //step3 = type email
        List<WebElement> listInputs = wd.findElements(By.tagName("input"));
        WebElement email = listInputs.get(0);
        email.click();
        email.clear();
        email.sendKeys("ololo@gmail.com");

        //step4 = type password
        WebElement pass = listInputs.get(1);
        wd.findElement(By.cssSelector("[placeholder='Password']"));
        pass.click();
        pass.clear();
        pass.sendKeys("12345");

        //step5 = click button login
        WebElement loginClick = wd.findElement(By.tagName("button"));
        wd.findElement(By.cssSelector("button"));
        loginClick.click();
    }

    //method "after"
    @AfterMethod
    public void postCondition() {
        //close www+browser

        //close all windows and browser
        // wd.close();

        //close window, not browser
        wd.quit();
    }
}

