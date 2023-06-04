package pageObjectLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class googlePage {

    WebDriver googlePageDriver;

    //Locators
    By txt_Search = By.xpath("//*[@id=\"APjFqb\"]");

    //Constructor that will be automatically called as soon as the object of the class is created
    public googlePage(WebDriver driver) {
        this.googlePageDriver = driver;
    }

    //Method to enter search text and search
    public void enterSearchTextAndSearch(String searchText){
        googlePageDriver.findElement(txt_Search).sendKeys(searchText);

        WebDriverWait wait = new WebDriverWait(googlePageDriver, Duration.ofSeconds(180));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")));

        //Press ENTER
        googlePageDriver.findElement(txt_Search).sendKeys(Keys.ENTER);
    }
}
