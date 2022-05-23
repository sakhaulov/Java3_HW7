package sakhaulov;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import sakhaulov.Atlassian.AtlassianWebDriverListener;

import java.time.Duration;

public abstract class AbstractTest {

    private static WebDriver driver;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        WebDriver original = new ChromeDriver(options);
        WebDriverListener listener = new AtlassianWebDriverListener();
        driver = new EventFiringDecorator(listener).decorate(original);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

//    @BeforeEach
//    void getPage() {
//        Assertions.assertDoesNotThrow(()-> driver.navigate().to("https://www.atlassian.com"),
//                              "Страница не доступна");
//    }

    @AfterAll
    public static void closeDriver() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
