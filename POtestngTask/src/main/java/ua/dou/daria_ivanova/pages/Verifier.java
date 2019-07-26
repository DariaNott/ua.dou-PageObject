package ua.dou.daria_ivanova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Verifier {
    private WebDriver driver;

    public Verifier (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyJobSearchResultsPresence (JobsPage page){
        String xPath = "//a[contains(text(),'Больше вакансий')]";
        page.waitVisibility(By.xpath(xPath));
        Boolean moreVacancies = driver.findElement(By.xpath(xPath)).isDisplayed();
        Assert.assertTrue(moreVacancies);
    }

    public void verifyJobSearchResultsAbsence (JobsPage page){
        String xPath = "//div[contains(@id,'vacancyListId')]/a";
        page.waitVisibility(By.xpath(xPath));
        Boolean moreVacancies = driver.findElement(By.xpath(xPath)).isDisplayed();
        Assert.assertTrue(moreVacancies);
    }

}
