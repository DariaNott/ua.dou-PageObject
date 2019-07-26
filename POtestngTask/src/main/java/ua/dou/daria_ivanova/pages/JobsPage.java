package ua.dou.daria_ivanova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class JobsPage extends BasePage {

    private By searchFieldXPath = By.xpath("//input[contains(@class,'job')]");
    private By categorySearchXPath = By.xpath("//select[contains(@name,'category')]");
    private By searchButtonClass = By.className("btn-search");

    public JobsPage(WebDriver driver) {
        super(driver);
    }

    public JobsPage searchFieldInput(String text) {
        writeText(searchFieldXPath, text);
        click(searchButtonClass);
        return this;
    }

    public JobsPage selectCategory(String text) {
        select(categorySearchXPath, text);
        return this;
    }

}
