import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class SeleniumPrzyklad {
    public static void main(String[] args) {
    //utworz obiekt o nazwie Webdriver wywolujac konstruktor ChromeDriover();
    WebDriver driver = new ChromeDriver();
    //zmaksymalizuj okno
    driver.manage().window().maximize();
    //przejdz do strony google.pl
    driver.navigate().to("https://www.google.pl");
    //kliknij Zgadzam sie
        driver.findElement(By.id("L2AGLb")).sendKeys(Keys.ENTER);
    //wyszukaj "lolcatz"
        driver.findElement(By.name("q")).sendKeys("lolcatz");
        //zatwierdz
        driver.findElement(By.name("q")).submit();
        //sprawdz czy strona ma tytul "lolcatz - Google Search
        Assertions.assertEquals("lolcatz - Szukaj w Google", driver.getTitle());
        //zamknij
        driver.close();


    }
}
