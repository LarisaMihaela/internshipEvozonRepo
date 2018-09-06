package com.evozon.ui.flowsteps;

import com.evozon.steps.serenity.RegisterSteps;
import com.evozon.tests.BaseTest;
//import com.evozon.utils.Constants;
import com.evozon.utils.Constants;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
//import net.thucydides.junit.annotations.UseTestDataFrom;

//@UseTestDataFrom(value = Constants.CSV_FILES_PATH + "01Test_Register.csv", separator = Constants.CSV_SEPARATOR)
public class RegisterUiFlowSteps {
	BaseTest bt = new BaseTest();
	//private String firstName, middleName, lastName, email, password, confirmedPasssword;

	@Steps
	RegisterSteps registerSteps;

	@Step
	public void registerWithValidCredentials() {
		registerSteps.openPage();
		registerSteps.setFirstNameField(Constants.REGISTER_FIRST_NAME);
		registerSteps.setMiddleNameField(Constants.REGISTE_MIDDLE_NAME);
	    registerSteps.setLastNameField(Constants.REGISTER_LAST_NAME);
	    registerSteps.setEmailField(Constants.REGISTER_EMAIL);
	    registerSteps.setPasswordField(Constants.REGISTER_PASSWORD);
	    registerSteps.setConfirmedPassword(Constants.REGISTER_PASSWORD);
	    registerSteps.clickRegisterButton();
	    registerSteps.isRegistered();
	    registerSteps.clickLogOutButton();
	}

}
