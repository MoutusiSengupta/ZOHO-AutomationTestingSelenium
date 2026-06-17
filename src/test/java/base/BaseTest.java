package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class BaseTest {
    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static Properties loc = new Properties();
    public static FileReader fr;
    public static FileReader fr1;
    @BeforeTest
    public void setUp() throws IOException {
        if (driver == null) {
            fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
            fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
            prop.load(fr);
            loc.load(fr1);
        }

        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(prop.getProperty("url"));
        }
    }
    @AfterTest
    public void tearDown(){
        BaseTest.driver.close();


    }
}
