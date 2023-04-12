import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumPractice2 {
    static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test
    void findLogin() {
        driver.get("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("test@softie.pl");
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("1qaz!QAZ");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
        driver.quit();
    }

    //negatywne
    @Test
    void wrongPass(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("test@softie.pl");
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("wrongpass");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText(), "Authentication failed.");
        driver.quit();
    }

    //tabele
    @Test
    void tableTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        List<WebElement> lista = driver.findElements(By.xpath("//*[@id=\"customers\"]//tr"));
        Assertions.assertEquals(lista.size(),7);
        Assertions.assertEquals("Giovanni Rovelli", driver.findElement(By.xpath("//table[@id='customers']//tr[td[text()='Magazzini Alimentari Riuniti']]/td[2]")).getText());
        Assertions.assertEquals("Canada", driver.findElement(By.xpath("//table[@id='customers']//tr[td[text()='Laughing Bacchus Winecellars']]/td[3]")).getText());
        Assertions.assertEquals("Mexico", driver.findElement(By.xpath("//table[@id='customers']//tr[td[text()='Centro comercial Moctezuma']]/td[3]")).getText());
        driver.close();
    }


    @Test
    void bmiTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bmi-online.pl/");
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"form-newsletter\"]/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/label/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"form-newsletter\"]/div[2]/div[1]/div/div/div[2]/div[2]/input")).sendKeys("95");
        driver.findElement(By.xpath("//*[@id=\"form-newsletter\"]/div[2]/div[1]/div/div/div[3]/div[2]/input")).sendKeys("185");
        driver.findElement(By.xpath("//*[@id=\"form-newsletter\"]/div[2]/div[1]/div/div/div[4]/div/button")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id=\"form-newsletter\"]/div[2]/div/div[1]/div/div[2]/div/div[1]/div[2]/span")).getText());
        driver.close();
    }

    // Account registration
    @Test
    void rejestracjaKonta(){
        Faker faker = new Faker();
        String uniqueEmail = faker.name().firstName() + faker.name().lastName() + faker.random().nextInt(10000) + "@gamil.com";
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.cssSelector("#email_create")).sendKeys(uniqueEmail);
        driver.findElement(By.cssSelector("#SubmitCreate")).click();
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("customer_lastname")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("passwd")).sendKeys("haslo1234");
        driver.findElement(By.id("firstname")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("lastname")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("city")).sendKeys(faker.address().city());
        driver.findElement(By.id("address1")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.id("postcode")).sendKeys("66183");
        driver.findElement(By.id("phone_mobile")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.id("alias")).sendKeys("asdsad1123");
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByValue("1");
        driver.findElement(By.id("submitAccount"));
        Assertions.assertEquals("My Account", driver.findElement(By.cssSelector("#center_column > h1")).getText());
    }

    // explicitly wait
    @Test
    public void explicitWait() {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.cssSelector("#start > button")).click();
        Wait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector("#finish > h4")));
        System.out.println(driver.findElement(By.cssSelector("#finish > h4")).getText());

    }
}