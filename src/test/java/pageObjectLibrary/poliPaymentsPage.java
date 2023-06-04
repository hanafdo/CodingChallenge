package pageObjectLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class poliPaymentsPage {

    WebDriver poliPageDriver;

    //Locators
    public By poliSignupBtn = By.xpath("//*[@id=\"header\"]/div/ul/a/span");

    //Constructor that will be automatically called as soon as the object of the class is created
    public poliPaymentsPage(WebDriver driver) {
        this.poliPageDriver = driver;
    }

    public void clickSignupButton(){

        poliPageDriver.findElement(poliSignupBtn).click();
    }
}
