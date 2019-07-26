package ua.dou.daria_ivanova.tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import ua.dou.daria_ivanova.pages.*;
import org.testng.annotations.Test;

public class JobSearchTests extends BaseTest {

    @DataProvider(name = "positive queries")
    public Object[][] dataProviderPositiveQueryMethod() {
        Object[][] dataProvider = new Object[3][1];
        dataProvider[0][0] = "qa engineer";
        dataProvider[1][0] = "java developer";
        dataProvider[2][0] = "python developer";
        return dataProvider;
    }

    @DataProvider(name = "fast search")
    public Object[][] dataProviderFastSearchMethos() {
        Object[][] dataProvider = new Object[3][1];
        dataProvider[0][0] = "//a[contains(text(),'начинающим')]";
        dataProvider[1][0] = "//a[contains(text(),'удаленная работа')]";
        dataProvider[2][0] = "//a[contains(text(),'работа за рубежом')]";
        return dataProvider;
    }

    @Test
    public void specialSymbolsCheck() {
        JobsPage jobsPage = homePage.goToHomePage().goToJobsPage().searchFieldInput(")(&&%$#@");
        verifier.verifyJobSearchResultsAbsence(jobsPage);
    }

    @Test
    public void invalidQueryCheck() {
        JobsPage jobsPage = homePage.goToHomePage().goToJobsPage().searchFieldInput("chef");
        verifier.verifyJobSearchResultsAbsence(jobsPage);
    }

    @Test(dataProvider = "positive queries")
    public void validQueryCheck(String query) {
        JobsPage jobsPage = homePage.goToHomePage().goToJobsPage().searchFieldInput(query);
        verifier.verifyJobSearchResultsPresence(jobsPage);
    }

    @Test(dataProvider = "fast search")
    public void fastSearchCheck(String path) {
        JobsPage jobsPage = homePage.goToHomePage().goToJobsPage();
        jobsPage.click(By.xpath(path));
        verifier.verifyJobSearchResultsPresence(jobsPage);
    }

    @Test
    public void categorySearchCheck () {
        JobsPage jobsPage = homePage.goToHomePage().goToJobsPage().selectCategory("C++");
        verifier.verifyJobSearchResultsPresence(jobsPage);
    }
}
