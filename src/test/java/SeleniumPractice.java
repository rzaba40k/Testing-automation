import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumPractice {
    static WebDriver driver;

    @BeforeAll
    static void Warmup() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void isTitleCorrect() {
        driver.navigate().to("https://pl.wikipedia.org");
        Assertions.assertTrue(driver.getPageSource().contains("Wikimedia Polska"));
        driver.navigate().refresh();
        Assertions.assertNotEquals(driver.getCurrentUrl(), "https://pl.wikipedia.org");
    }

    @AfterAll
    static void CloseUp() {
        driver.close();
    }
}
