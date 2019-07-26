package ua.dou.daria_ivanova.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import ua.dou.daria_ivanova.pages.HomePage;
import ua.dou.daria_ivanova.pages.Verifier;

public abstract class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    protected Verifier verifier;

    @BeforeTest
    public void setChrome() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        verifier = new Verifier(driver);
    }

    @AfterTest
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}
