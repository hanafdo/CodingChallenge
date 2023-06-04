package pageObjectLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class securepayPage {
    WebDriver securepayPageDriver;

    //Locators
    public By Pricing = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/header/div/div/div[2]/nav/ul/li[2]/div/span");
    By standardPricing = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/header/div/div/div[2]/nav/ul/li[2]/div/div/div/ul/li[1]/a");

    //Constructor that will be automatically called as soon as the object of the class is created
    public securepayPage(WebDriver driver) {
        this.securepayPageDriver = driver;
    }

    //Methods

    public void clickOnStandardPricing(){
        // Locating the Main Menu (Parent element)
        WebElement mainMenu = securepayPageDriver.findElement(Pricing);

        //Instantiating Actions class
        Actions actions = new Actions(securepayPageDriver);

        //Hovering on main menu
        actions.moveToElement((mainMenu));

        // Locating the element from Sub Menu
        WebElement subMenu = securepayPageDriver.findElement(standardPricing);

        //To mouseover on sub menu
        actions.moveToElement(subMenu);

        //build()- used to compile all the actions into a single step
        actions.click().build().perform();
    }
}
