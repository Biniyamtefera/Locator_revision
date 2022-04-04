package LoginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class customeLoginPage {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        driver.get("http://localhost:8000");

        // Happy Path test - login succeeds
        // Locate web elements
        WebElement username = driver.findElement(By.cssSelector("#username"));
        WebElement password = driver.findElement(By.cssSelector("#password"));
        WebElement submit = driver.findElement(By.name("submit"));

        // Perform actions
        username.sendKeys("registeredUser");
        password.sendKeys("1234");
        submit.click();
        Thread.sleep(5000);
        String message = driver.findElement(By.cssSelector("#auth-message")).getText();
        System.out.println(message);

        // Sad Path test - login fails
        // Locate web elements
        driver.get("http://localhost:8000");
        WebElement username2 = driver.findElement(By.cssSelector("#username"));
        WebElement password2 = driver.findElement(By.cssSelector("#password"));
        WebElement submit2 = driver.findElement(By.name("submit"));

        // Perform actions
        username2.sendKeys("otherUser");
        password2.sendKeys("qwerty1234");
        submit2.click();
        Thread.sleep(5000);
        String message2 = driver.findElement(By.cssSelector("#auth-message")).getText();
        System.out.println(message2);

        // Create acct
        WebElement createAccountLink = driver.findElement(By.linkText("Create an account"));
        createAccountLink.click();

        Thread.sleep(5000);

        String header = driver.findElement(By.cssSelector("#header")).getText();
        System.out.println(header);

        driver.quit();
    }

}
