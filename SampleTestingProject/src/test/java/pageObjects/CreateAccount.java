package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccount extends BasePage {

	// Constructor
	public CreateAccount(WebDriver driver) {
	        super(driver);
	    }
	    
	// Page URL
    private static final String PAGE_URL = "https://magento.softwaretestingboard.com/customer/account/create/";

    // Web Elements (using @FindBy annotations)
    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(id = "email_address")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "password-confirmation")
    private WebElement passwordConfirmationInput;

    @FindBy(css = "button[title='Create an Account']")
    private WebElement createAccountButton;
    
    @FindBy(xpath="(//li//a[contains(text(),'Sign Out')])[1]")
    private WebElement signOutButton;
    
    @FindBy(xpath="//span[contains(@class,'logged-in')]")
    private WebElement myAccountIcon;
    
    // Methods to interact with web elements

    public void open() {
        driver.get(PAGE_URL);
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterPasswordConfirmation(String passwordConfirmation) {
        passwordConfirmationInput.sendKeys(passwordConfirmation);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    // Method to fill in all required fields
    public void fillInRequiredFields(String firstName, String lastName, String email, String password) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        enterPasswordConfirmation(password); // Assuming password and confirmation are the same
    }
    public void signOut() {
    	myAccountIcon.click();
    	signOutButton.click();
    }
}
