import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class SeleniumExample {
    public static void main(String[] args) {
    // creates object called Webdriver that contains ChromeDriver constructor;
    WebDriver driver = new ChromeDriver();
    // maximize window
    driver.manage().window().maximize();
    // navigate to page google.pl
    driver.navigate().to("https://www.google.pl");
    // click accept
        driver.findElement(By.id("L2AGLb")).sendKeys(Keys.ENTER);
    // search for "lolcatz"
        driver.findElement(By.name("q")).sendKeys("lolcatz");
        // confirm
        driver.findElement(By.name("q")).submit();
        // checks if the title of the page is "lolcatz - Google Search"
        Assertions.assertEquals("lolcatz - Szukaj w Google", driver.getTitle());
        // closes window
        driver.close();


    }
}
