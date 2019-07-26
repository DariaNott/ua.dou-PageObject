package ua.dou.daria_ivanova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {


    private String baseURL = "https://dou.ua/";

    //Web Elements
    By jobsButtonXPath = By.xpath("//header//a[contains(text(),'Работа')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    //Page Methods
    public HomePage goToHomePage() {
        driver.get(baseURL);
        return this;
    }

    public JobsPage goToJobsPage() {
        click(jobsButtonXPath);
        return new JobsPage(driver);
    }


}