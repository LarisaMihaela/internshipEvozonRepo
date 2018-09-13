package cucumber.stepDefinitions;

import com.evozon.steps.serenity.HomePageSteps;
import com.evozon.steps.serenity.LoginSteps;
import com.evozon.utils.Constants;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.junit.annotations.UseTestDataFrom;
@UseTestDataFrom(value = Constants.CSV_FILES_PATH + "Test01_LoginWithValidCredentials.csv", separator = Constants.CSV_SEPARATOR)
public class stepDefinition {
		String result;
		LoginSteps loginSteps;
		HomePageSteps homePageSteps;
		
	
		@Given("^User is on HomePage$")
	    public void user_is_on_homepage()  {
			homePageSteps.openPage();
		}

	    @When("^User goes to account and Clicks Login$")
	    public void user_goes_to_account_and_clicks_login() {
	    	loginSteps.openPage();
	    }
	    
	    @Then("^User introduces email (.+) and password (.+)$")
	    public void user_introduces_email_and_password(String username, String password) throws Throwable {
	    	loginSteps.setEmailNameField(username);
			loginSteps.setPasswordField(password);
			loginSteps.clickLoginButton();
	    }

	    @And("^User is redirected to Account Information Page$")
	    public void user_is_redirected_to_account_information_page() {
	    	loginSteps.checkValidationAdvice(result);
	    }

	    

}
