import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selectory {
    static WebDriver driver;

    @BeforeAll
    static void Warmup() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stackoverflow.com/");
    }

    //zad1 - menu nawigacyjne
    @Test
    void findNavigationMenu() {
        driver.findElement(By.xpath("/html/body/header/div/div[1]/a[1]"));
    }

    //zad 1 - searchbar
    @Test
    void findSearchBar() {
        driver.findElement(By.name("q"));
    }

    //zad 1 - login
    @Test
    void findLogInButton() {
        driver.findElement(By.className("login-link"));
    }

    //zad 1 - jointhecommunity
    @Test
    void findJoinTheCommunity() {
        driver.findElement(By.linkText("Join the community"));
    }

    @AfterAll
    static void CloseUp() {
        driver.close();
    }
}
