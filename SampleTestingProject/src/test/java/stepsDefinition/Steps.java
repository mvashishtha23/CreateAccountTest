package stepsDefinition;

import java.time.Duration;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

//import com.aventstack.extentreports.util.Assert;
import org.testng.Assert;

//import io.cucumber.messages.types.Duration;
import pageObjects.CreateAccount;
//import org.testng.Assert;



public class Steps {

    private WebDriver driver = Hooks.driver;
    private CreateAccount createAccountPage = new CreateAccount(driver);
    private String generatedEmail;
    
	  @Given("I am on the create new customer account page")
	    public void CreateNewCustomerAccountPage() {
	        createAccountPage.open();
	    }

	    @When("I fill in all required fields with valid information")
	    public void FillAllRequiredFields() {
	        String timestamp = String.valueOf(System.currentTimeMillis());
	        generatedEmail = "testuser" + timestamp + "@example.com";
	        createAccountPage.fillInRequiredFields("Mahima", "Vashishtha", generatedEmail, "Password123!");
	    }

	    @When("I click the create an account button")
	    public void ClickCreateAccountButton() {
	        createAccountPage.clickCreateAccountButton();
	    }

	    @Then("I should see a success message")
	    public void SeeASuccessMessage() {
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        Assert.assertTrue(driver.getPageSource().contains("Thank you for registering with Main Website Store."));
	    }

	    @Then("I should be logged in")
	    public void ShouldBeLoggedIn() {
	        Assert.assertTrue(driver.getCurrentUrl().contains("customer/account"));
	        
	    }

	    @When("I fill in the email field with an existing email address")
	    public void FillEmailFieldWithAnExistingEmailAddress() {
	        String existingEmail = "existing.user@example.com";
	        createAccountPage.enterFirstName("Mahima");
	        createAccountPage.enterLastName("Vashishtha");
	        createAccountPage.enterEmail(existingEmail);
	        createAccountPage.enterPassword("Password123!");
	        createAccountPage.enterPasswordConfirmation("Password123!");
	    }

	    @When("I fill in the remaining required fields with valid information")
	    public void FillRemainingRequiredFieldsWithValidInformation() {
	        // Assume name and password are reused for simplicity
	        createAccountPage.enterFirstName("Test");
	        createAccountPage.enterLastName("User");
	        createAccountPage.enterPassword("Password123!");
	        createAccountPage.enterPasswordConfirmation("Password123!");
	    }

	    @Then("I should see an error message indicating the email is already registered")
	    public void ShouldSeeErrorMessage() {
	        Assert.assertTrue(driver.getPageSource().contains("There is already an account with this email address."));
	    }
	    
	}


