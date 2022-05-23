package sakhaulov;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import sakhaulov.Atlassian.AtlassianWebDriverEventListener;
import sakhaulov.Utils.TestUtils;

import java.time.Duration;

public abstract class AbstractTest {

    private static EventFiringWebDriver driver;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        driver = new EventFiringWebDriver(new ChromeDriver(options));
        driver.register(new AtlassianWebDriverEventListener());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    void getInfo() {
        System.out.println("*** Browser Logs ***");
        String fileName = "failure-" + System.currentTimeMillis() + ".png";
        TestUtils.makeScreenshot(driver, fileName);
        TestUtils.getLogs(driver);
    }

//    @BeforeEach
//    void getPage() {
//        Assertions.assertDoesNotThrow(()-> driver.navigate().to("https://www.atlassian.com"),
//                              "Страница не доступна");
//    }

    @AfterAll
    public static void closeDriver() {
        if (driver != null) driver.quit();
    }

    public static EventFiringWebDriver getDriver() {
        return driver;
    }

}
