package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjectLibrary.*;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Locale;

import static org.testng.Assert.assertTrue;


public class Steps {

    WebDriver driver = null;
    googlePage googlePOM;
    searchResultsPage resultsPOM;
    securepayPage securepayPOM;
    standardPricingPage standardPagePOM;
    poliPaymentsPage poliPaymentsPOM;
    poliSignupPage poliSignupPOM;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/test/resources/chromedriver_win32/chromedriver.exe").toString());
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    @After
    public void tearDown() {
        if (driver!=null) {
            driver.close();
            driver.quit();
        }
    }

    @Given("The user navigate to google page")
    public void The_user_navigate_to_google_page() {

        driver.navigate().to("https://www.google.com.au/");
    }
    @Then("The user search for SecurePay")
    public void The_user_search_for_secure_pay() throws InterruptedException {

        googlePOM = new googlePage(driver);
        googlePOM.enterSearchTextAndSearch("secure pay");
    }
    @And("The user click and navigates to SecurePay")
    public void the_user_click_and_navigates_to_secure_pay() {

        resultsPOM = new searchResultsPage(driver);
        resultsPOM.clickWebsiteLink();
    }

    @And("Navigate to Standard Pricing page")
    public void navigate_to_standard_pricing_page(){
        securepayPOM = new securepayPage(driver);

        //Verify secure pay website is opened
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
        wait.until(ExpectedConditions.elementToBeClickable(securepayPOM.Pricing));
        assertTrue(driver.findElement(securepayPOM.Pricing).isDisplayed());

        //Select Pricing -> Standard Pricing
        securepayPOM.clickOnStandardPricing();
    }

    @When("Verify if the user is on Standard Pricing page")
    public void verify_if_the_user_is_on_standard_pricing_page() {
        standardPagePOM = new standardPricingPage(driver);

        //Wait for page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
        wait.until(ExpectedConditions.visibilityOfElementLocated(standardPagePOM.standardPackage));

        //Verify standard pricing web page is opened
        WebElement standardElement = driver.findElement(standardPagePOM.standardPackage);
        String text = standardElement.getText();
        Assert.assertEquals("Standard", text);
    }

    @When("The User clicks on Learn more button under POLi")
    public void the_user_clicks_on_learn_more_button_under_poli(){
        standardPagePOM = new standardPricingPage(driver);
        standardPagePOM.clickOnLearnMore();
    }

    @Then("Verify if POLi is opened & loaded in a new window")
    public void verify_if_poli_is_opened_and_loaded_in_a_new_window(){
        poliPaymentsPOM = new poliPaymentsPage(driver);

        // hold all window handles in array list
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb.get(1));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
        wait.until(ExpectedConditions.elementToBeClickable(poliPaymentsPOM.poliSignupBtn));

        //Verify the new tab displays the correct page
        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.contains("POLi Payments"));
    }

    @When("The user click on Sign up now button")
    public void the_user_click_on_sign_up_now_button(){
        poliPaymentsPOM = new poliPaymentsPage(driver);
        poliPaymentsPOM.clickSignupButton();
    }

    @And("User selects POLi signup for an Australian online business")
    public void user_selects_poli_signup_for_an_australian_online_business(){
        poliSignupPOM = new poliSignupPage(driver);

        // hold all window handles in array list
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb.get(2));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
        wait.until(ExpectedConditions.elementToBeClickable(poliSignupPOM.ausOnlineBusiness));

        //Select I have an Australian Online Business option
        poliSignupPOM.clickAusOnlineBusiness();

        //Verify that Details about the business section is collapsed
        WebElement businessDetailsHeading = driver.findElement(poliSignupPOM.businessDetailHeading);
        String headingClass = businessDetailsHeading.getAttribute("class");
        Assert.assertEquals("banner down", headingClass);
    }

    @Then("The User fill details about the company with (.*) and (.*) and (.*) and (.*) and (.*)$")
    public void the_user_fill_details_about_the_business(String companyNumber, String addressState, String industryName, String shoppingCart, String companyWebsite) {
        poliSignupPOM = new poliSignupPage(driver);

        Faker auFaker = new Faker(new Locale("en-AU"));

        String firstName = auFaker.name().firstName();
        String lastName = auFaker.name().lastName();
        String emailAddress = auFaker.internet().emailAddress();
        String phoneNum = auFaker.phoneNumber().cellPhone();
        String addressOne = auFaker.address().streetAddress();
        String addressCity = auFaker.address().city();
        String addressPostcode = auFaker.address().zipCode();

        poliSignupPOM.setUserDetails(firstName,lastName,emailAddress,phoneNum);

        poliSignupPOM.setBusinessDetails(companyNumber,addressOne,addressState,addressCity,addressPostcode,industryName,shoppingCart,companyWebsite);
    }

    @And("User click on the second section")
    public void user_click_on_the_second_section(){
        poliSignupPOM = new poliSignupPage(driver);
        poliSignupPOM.clickStepTwo();
    }

    @And("Fills payment details with (.*) and (.*)$")
    public void fills_payment_details_with_account_and_BSB(String accountName, String paymentBSB){
        poliSignupPOM = new poliSignupPage(driver);

        //Wait for page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
        wait.until(ExpectedConditions.visibilityOfElementLocated(poliSignupPOM.accountNameTextbox));
        poliSignupPOM.setPaymentDetails(accountName,paymentBSB);
    }

    @Then("Verify account details are populated correctly with (.+) and (.*)$")
    public void verify_account_details_are_populated_correctly(String bankName, String bsbName){
        poliSignupPOM = new poliSignupPage(driver);

        //Wait for account details to populate
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
        wait.until(ExpectedConditions.visibilityOfElementLocated(poliSignupPOM.bankTextLabel));

        //Verify the populated details are correct
        WebElement banknameLabel = driver.findElement(poliSignupPOM.bankTextLabel);
        String bank = banknameLabel.getText();
        WebElement bsbLabel = driver.findElement(poliSignupPOM.bsbTextLabel);
        String bsb = bsbLabel.getText();

        Assert.assertEquals(bankName, bank);
        Assert.assertEquals(bsbName, bsb);


    }
}
