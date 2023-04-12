import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;


public class Project {
    static WebDriver driver;
    //String testedpage;
    //testedpage = "http://automationpractice.com/";

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    void navigation() { // Store navigation
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]")).click();
        driver.findElement(By.cssSelector("#categories_block_left > div > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[2]/h5/a")).click();
        driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/span")).getText(), "T-shirts");
        driver.quit();
    }

    @Test
    void addToCart() { // Adding product to your cart
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id=\"home-page-tabs\"]/li[2]/a")).click();
        Actions action = new Actions(driver);
        WebElement dress = driver.findElement(By.xpath("//*[@id=\"blockbestsellers\"]/li[1]/div/div[1]/div/a[1]/img"));
        action.moveToElement(dress).perform(); // mouse hover over chosen element
        driver.findElement(By.xpath("//*[@id=\"blockbestsellers\"]/li[1]/div/div[2]/div[2]/a[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"product_7_34_0_0\"]/td[2]/p")).getText(), "Printed Chiffon Dress");
        driver.quit();
    }

    @Test
    void newsletterNegative() { // Newsletter registration using wrong email
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        driver.findElement(By.id("newsletter-input")).sendKeys("test@test");
        driver.findElement(By.xpath("//*[@id=\"newsletter_block_left\"]/div/form/div/button")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"columns\"]/p")).getText(), "Newsletter : Invalid email address.");
        driver.quit();
    }
    @Test
    void accountRegistration() {  // Account registration
        WebDriver driver = new ChromeDriver();
        Faker faker = new Faker();
        String uniqueEmail = faker.name().firstName() + faker.name().lastName() + faker.random().nextInt(10000) + "@gamil.com";
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
        driver.findElement(By.id("alias")).sendKeys("Test");
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByValue("1");
        driver.findElement(By.id("submitAccount")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
        driver.quit();
    }
    @Test
    void wrongPassword() { // Login with wrong password
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("test@test.pl");
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("wrongpass");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText(), "Authentication failed.");
        driver.quit();
    }
    @Test
    void login() { // Login using correct credentials
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("jga34528@boofx.com");
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
        driver.quit();
    }
    @Test
    void checkout(){ // Adding product to cart and checkout
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        WebElement menu = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
        WebElement blouse = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]"));
        WebElement back = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span"));
        WebElement tshirt = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]"));
        driver.get("http://automationpractice.com/");
        action.moveToElement(menu).perform();
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a")).click();
        action.moveToElement(blouse).perform();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span")).click();
        Select blouseSize = new Select(driver.findElement(By.xpath("//*[@id=\"group_1\"]")));
        blouseSize.selectByVisibleText("M");
        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
        action.moveToElement(back).click();
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
        action.moveToElement(tshirt).perform();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("jga34528@boofx.com");
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
        driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();
        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText(),"ORDER CONFIRMATION");
        driver.quit();
    }
}