package pageObjectLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class standardPricingPage {
    WebDriver standardPricingPageDriver;

    //Locators
    public By standardPackage = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/main/section[1]/div[2]/div/div/div/div/div[1]/div/h5");
    By learnMore = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/main/section[3]/div[2]/div/div/div/div/div[1]/div/a");

    //Constructor that will be automatically called as soon as the object of the class is created
    public standardPricingPage(WebDriver driver) {
        this.standardPricingPageDriver = driver;
    }

    //Methods
    public void clickOnLearnMore(){
        WebDriverWait wait = new WebDriverWait(standardPricingPageDriver, Duration.ofSeconds(180));
        wait.until(ExpectedConditions.elementToBeClickable(learnMore));

        standardPricingPageDriver.findElement(learnMore).click();
    }
}
