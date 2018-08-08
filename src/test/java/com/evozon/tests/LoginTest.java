package com.evozon.tests;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.evozon.steps.serenity.LoginSteps;
import com.evozon.utils.Constants;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.CSV_FILES_PATH + "Test01_LoginWithValidCredentials.csv", separator = Constants.CSV_SEPARATOR)
public class LoginTest extends BaseTest {
	
	private String email,password;
	private String invalidPassword = "serenitytest23";
	
	@Steps
		LoginSteps loginSteps;
	
	@Test
	@Title("Test01_LoginWithValidCredentials")
		public void loginWithValidCredentials() {
		loginSteps.openPage();
		loginSteps.setEmailNameField(email);
		loginSteps.setPasswordField(password);
		loginSteps.clickLoginButton();
		loginSteps.clickAccountHeader();
		loginSteps.clickLogoutButton();
	}
	
		@Test @Ignore
		public void loginWithInvalidCredentials() {
			loginSteps.openPage();
			loginSteps.setEmailNameField(email);
			loginSteps.setPasswordField(invalidPassword);
			loginSteps.clickLoginButton();
		}

}
