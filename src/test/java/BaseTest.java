import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {

    public static WebDriver driver;

    @BeforeScenario
    public static void setUp(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--lang=en");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://splice.com/sounds/beatmaker");
    }

    @AfterScenario
    public static void tearDown(){
        driver.close();
        driver.quit();
    }
}