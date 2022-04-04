package wikipediaPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class RandomWikiTest2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://en.wikipedia.org");

        driver.findElement(By.cssSelector("#n-randompage")).click();

        System.out.println(driver.getTitle());

        //print first heading

        String firstHeading = driver.findElement(By.cssSelector(".firstHeading")).getText();
        System.out.println(firstHeading);

        //view page Info
        driver.findElement(By.linkText("Page information")).click();
        Thread.sleep(5000);

        //New Search
        driver.findElement(By.name("Search")).sendKeys(("Selenium (software)" + Keys.RETURN));

        // XPath Logo Click
        String xpath = "/html/body/div[4]/div[2]/div[1]/a";
        driver.findElement(By.xpath(xpath));
        Thread.sleep(5000);

        driver.quit();



    }
}
