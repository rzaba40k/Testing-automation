import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class PlayAutomation {
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.play.pl/");
    }

    @Test
    void BuyThroughPhone() { // Use of "Kup przez telefon" form using correct phone number
        WebDriverWait wait = new WebDriverWait(driver,30);
        Faker faker = new Faker();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"))).click();
        driver.findElement(By.xpath("//*[@id=\"id-0\"]")).sendKeys(faker.numerify("###-###-###"));
        driver.findElement(By.xpath("//*[@id=\"app\"]/footer/section[1]/div/div/div[1]/div[2]/form/div[2]/label/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/footer/section[1]/div/div/div[1]/div[2]/button/span")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div/div[2]")));
        Assertions.assertEquals(driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div/div[2]/h1"))
                .getText(),"Dziękujemy za pozostawienie numeru");
        driver.quit();
    }

    @Test
    void PhoneAddToCart() { // Navigate to the store page, then add phone to cart
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"))).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/section/div[2]/div/div[2]/div/ul/li[1]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"v-navbar-menu-level-2-0\"]/div/div[1]/div[2]/div/div/ul/li[1]/div/div/ul/li[2]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"listing\"]/section/div/div[1]/article[2]/div/div[2]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"product\"]/aside/div/section[1]/div/ul/li[1]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"product\"]/aside/div/section[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"add-addon-to-cart\"]/div/div[2]/div[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-addon-to-cart\"]/div/div[3]/div/div/button")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"main-container\"]/headline-component/div/div/div/h2")).getText(),"Twój koszyk");
        driver.quit();
    }

    @Test
    void StoreSorting () { // Navigate to store page, then sort by make - "Nokia"
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement menuTablety = driver.findElement(By.xpath("//*[@id=\"v-navbar-menu-level-2-0\"]/div/div[1]/div[2]/div/div/ul/li[3]/button/span"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"))).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/section/div[2]/div/div[2]/div/ul/li[1]/button")).click();
        action.moveToElement(menuTablety).build().perform();
        driver.findElement(By.xpath("//*[@id=\"v-navbar-menu-level-2-0\"]/div/div[1]/div[2]/div/div/ul/li[3]/div/div/ul/li[3]/a/span")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//*[@id=\"v-navbar-menu-level-2-0\"]/div/div[1]/div[2]/div/div/ul/li[3]/div/div/ul/li[3]/a/span"))).click();
        driver.findElement(By.xpath("//*[@id=\"listing\"]/aside/div/div/div[2]/div[2]/div/div[1]/div[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"listing\"]/aside/div/div/div[2]/div[2]/div/div[2]/ul/li[3]/label")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"listing\"]/aside/div/div/div[2]/div[1]/ul/li/span")).getText(),"Nokia");
        driver.quit();
    }

    @Test
    void HelpPage () { // navigate to the Help page, then assert contents of pages
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"))).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/section/div[2]/div/div[1]/div/div[1]/ul/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/main/section[2]/div/div/div/div[1]/div/div/div/div/p/a/strong")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/main/section[1]/div/div/div/div[1]/div")).getText(), "Pierwsze kroki");
        driver.findElement(By.xpath("//*[@id=\"app\"]/main/section[1]/div/div/div/div[4]/div/p")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/main/section[1]/section/div/div/div/div/div/section/h1"))
                .getText(), "Doładowania");
        driver.findElement(By.xpath("//*[@id=\"app\"]/main/section[10]/div/div/div/nav/p/span[2]/span[2]/span/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/main/section[2]/div/div/div/div[8]/div/div/div/div/p/a/strong")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/main/section[3]/div/div/div/h2")).getText(),"Telewizja i internet");
        driver.findElement(By.xpath("//*[@id=\"app\"]/main/section[2]/div/div/div/div[4]/div/p")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/main/section[1]/section/div/div/div/div/div/section/h1"))
                .getText(), "Rękojma i gwarancja");
        driver.quit();
    }

    @Test
    void AssertTitle () { // Asserts if title of the page is correct
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")))
                .click();
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Abonament komórkowy, internet, telewizja | Dołącz do Play | Play";
        Assertions.assertEquals(ExpectedTitle, ActualTitle);
        driver.quit();
    }
    @Test
    void MapaSalonowNegative () { // Navigate to the map of sales points, then enters incorrect postal code and checks if the error message is correct
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"))).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/section/div[2]/div/div[1]/div/div[1]/ul/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/main/section[2]/div/div/div/div[6]/div/div/div/div/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"services-search\"]")).sendKeys("123a441");
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[1]/div[1]/button")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[1]/div[1]/div[2]/text()"))
                .getText(),"Niestety nie znaleźliśmy podanego adresu. Sprawdź czy wpisany adres jest prawidłowy i spróbuj ponownie");
        driver.quit();
    }

}
