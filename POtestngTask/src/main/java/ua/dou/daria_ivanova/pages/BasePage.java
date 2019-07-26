package ua.dou.daria_ivanova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;



public abstract class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    //Waiter Wrapper Method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementBy));
    }

    public void waitToBeClickable(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    //Action Methods
    public void click(By elementBy) {
        waitToBeClickable(elementBy);
        driver.findElement(elementBy).click();
    }

    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    public void select(By elementBy, String textToSelect) {
        WebElement dropdown = driver.findElement(elementBy);
        Select category = new Select(dropdown);
        click(elementBy);
        category.selectByVisibleText(textToSelect);
    }
}

