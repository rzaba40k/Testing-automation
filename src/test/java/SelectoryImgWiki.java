import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectoryImgWiki {
    static WebDriver driver;

    @Test
    void findimg() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pl.wikipedia.org/");
        driver.findElement(By.cssSelector("#p-logo > a"));
        driver.findElement(By.xpath("//*[@id=\"n-pierwsze-kroki\"]/a/span"));
        driver.findElement(By.xpath("//*[@id=\"pt-login\"]/a/span"));
        driver.findElement(By.cssSelector("#main-page-wiki-events > p"));
        driver.close();
    }
    @Test
    void findXpath() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a"));
        driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a"));
        driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
        driver.findElement(By.xpath("//*[@id=\"email\"]"));
        driver.findElement(By.xpath("//*[@id=\"login_form\"]/div/p[1]/a"));
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
        driver.close();
    }
}
