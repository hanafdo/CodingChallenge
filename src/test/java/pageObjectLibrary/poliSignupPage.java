package pageObjectLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class poliSignupPage {
    WebDriver poliSignupPageDriver;

    //Locators
    public By ausOnlineBusiness = By.xpath("//*[@id=\"tariffdata\"]/ul/li[1]");
    public By businessDetailHeading = By.xpath("//*[@id=\"profileDetails\"]/div[2]");
    By firstnameTextbox = By.xpath("//*[@id=\"FirstName\"]");
    By lastnameTextbox = By.xpath("//*[@id=\"LastName\"]");
    By emailTextbox = By.xpath("//*[@id=\"EmailAddress\"]");
    By phoneTextbox = By.xpath("//*[@id=\"PhoneNumber\"]");
    By abnTextbox = By.xpath("//*[@id=\"RegNo\"]");
    By addressOneTextbox = By.xpath("//*[@id=\"Address1\"]");
    By addressStateDropdown = By.xpath("//*[@id=\"State\"]");
    By cityTextbox = By.xpath("//*[@id=\"City\"]");
    By postcodeTextbox = By.xpath("//*[@id=\"PostCode\"]");
    By industryDropdown = By.xpath("//*[@id=\"OperatedIndustry\"]");
    By cartDropdown = By.xpath("//*[@id=\"ShoppingCart\"]");
    By websiteTextbox = By.xpath("//*[@id=\"Website\"]");
    By sectionTwo = By.xpath("//*[@id=\"paymentDetails\"]/div[1]");
    public By accountNameTextbox = By.xpath("//*[@id=\"AccountName\"]");
    By bsbTextbox = By.xpath("//*[@id=\"BSB\"]");

    public By bankTextLabel = By.xpath("//*[@id=\"banktxt\"]");
    public By bsbTextLabel = By.xpath("//*[@id=\"bsbtxt\"]");

    //Constructor that will be automatically called as soon as the object of the class is created
    public poliSignupPage(WebDriver driver) {

        this.poliSignupPageDriver = driver;
    }

    public void clickAusOnlineBusiness(){

        poliSignupPageDriver.findElement(ausOnlineBusiness).click();
    }

    public void setUserDetails(String fName, String lName, String email, String phone){

        poliSignupPageDriver.findElement(firstnameTextbox).sendKeys(fName);
        poliSignupPageDriver.findElement(lastnameTextbox).sendKeys(lName);
        poliSignupPageDriver.findElement(emailTextbox).sendKeys(email);
        poliSignupPageDriver.findElement(phoneTextbox).sendKeys(phone);
    }

    public void setBusinessDetails(String abn, String addOne, String addState, String addCity, String addPostcode, String industry, String cart, String website){

        poliSignupPageDriver.findElement(abnTextbox).sendKeys(String.valueOf(abn));
        poliSignupPageDriver.findElement(addressOneTextbox).sendKeys(addOne);
        poliSignupPageDriver.findElement(addressStateDropdown).sendKeys(addState);
        poliSignupPageDriver.findElement(cityTextbox).sendKeys(addCity);
        poliSignupPageDriver.findElement(postcodeTextbox).sendKeys(addPostcode);
        poliSignupPageDriver.findElement(industryDropdown).sendKeys(industry);
        poliSignupPageDriver.findElement(cartDropdown).sendKeys(cart);
        poliSignupPageDriver.findElement(websiteTextbox).sendKeys(website);
    }

    public void clickStepTwo(){
        poliSignupPageDriver.findElement(sectionTwo).click();
    }

    public void setPaymentDetails(String accountName, String bsb){
        poliSignupPageDriver.findElement(accountNameTextbox).sendKeys(accountName);
        poliSignupPageDriver.findElement(bsbTextbox).sendKeys(bsb);
    }
}
