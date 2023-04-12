import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.pdfbox.text.PDFTextStripper;




public class PDFTesting {
    static WebDriver driver;

    @BeforeAll
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void verifyPDF() {
        String pdfadress = "https://www.podatki.gov.pl/media/3029/instrukcja-korzystania-z-formularzy-interaktywnych-pdf.pdf";
        driver.get(pdfadress);
        String pdfContent = getPdfContent(pdfadress);
    }




    }
}
