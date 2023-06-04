package pageObjectLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class searchResultsPage {
    WebDriver searchResultsPageDriver;

    //Locators
    By websiteLink = By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/a/h3");

    //Constructor that will be automatically called as soon as the object of the class is created
    public searchResultsPage(WebDriver driver) {
        this.searchResultsPageDriver = driver;
    }

    //Method to click on securepay link
    public void clickWebsiteLink(){
        WebDriverWait wait = new WebDriverWait(searchResultsPageDriver, Duration.ofSeconds(180));
        wait.until(ExpectedConditions.elementToBeClickable(websiteLink));

        searchResultsPageDriver.findElement(websiteLink).click();
    }
}
