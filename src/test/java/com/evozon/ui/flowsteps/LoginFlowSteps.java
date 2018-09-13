package com.evozon.ui.flowsteps;


import com.evozon.steps.serenity.LoginSteps;
import com.evozon.utils.Constants;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

@UseTestDataFrom(value = Constants.CSV_FILES_PATH + "Test01_LoginWithValidCredentials.csv", separator = Constants.CSV_SEPARATOR)
public class LoginFlowSteps {

	private String email,password,result;
	private String invalidPassword = "serenitytest23";
	
	@Steps
		LoginSteps loginSteps;
	
	@Step
	@Title("Test01_LoginWithValidCredentials")
		public void loginWithValidCredentials() {
		loginSteps.openPage();
		loginSteps.setEmailNameField(Constants.REGISTER_EMAIL);
		loginSteps.setPasswordField(Constants.REGISTER_PASSWORD);
		loginSteps.clickLoginButton();
		loginSteps.checkValidationAdvice(result);
	}
	
	@Step
	@Title("LogOut")
		public void logOut() {
		loginSteps.clickAccountHeader();
		loginSteps.clickLogoutButton();
	}
	
	@Step
	public void loginWithInvalidCredentials() {
		loginSteps.openPage();
		loginSteps.setEmailNameField(email);
		loginSteps.setPasswordField(invalidPassword);
		loginSteps.clickLoginButton();
		}

	
}
