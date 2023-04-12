import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SelectorsPractice {
    static WebDriver driver;

    @Test
    void findElements() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
        List<WebElement> Lista = driver.findElements(By.className("col-sm-4"));
        System.out.println(Lista.size());
        driver.quit();
    }


    @Test
    void findImages(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
        List<WebElement> Lista1 = driver.findElements(By.tagName("img"));
        System.out.println(Lista1.size());
        driver.quit();
    }


    @Test
    void findNewsletterBar() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
        List<WebElement> newsletter = driver.findElements(By.id("newsletter-input"));
        Assertions.assertEquals(1, newsletter.size());
        driver.quit();
    }
}