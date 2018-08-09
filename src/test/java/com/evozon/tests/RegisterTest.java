package com.evozon.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.evozon.steps.serenity.RegisterSteps;
import com.evozon.utils.Constants;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.CSV_FILES_PATH + "01Test_Register.csv", separator = Constants.CSV_SEPARATOR)
		public class RegisterTest extends BaseTest {
		
			BaseTest bt = new BaseTest();
			private String firstName, middleName, lastName, email, password, confirmedPasssword;
	
	@Steps
		RegisterSteps registerSteps;
	
	@Test
	@Title("01Test_Register")
		public void registerWithValidCredentials() {
			registerSteps.openPage();
			registerSteps.setFirstNameField(firstName);
			registerSteps.setMiddleNameField(middleName);
	        registerSteps.setLastNameField(lastName);
	        registerSteps.setEmailField(email);
	        registerSteps.setPasswordField(password);
	        registerSteps.setConfirmedPassword(confirmedPasssword);
	        registerSteps.clickRegisterButton();
	        registerSteps.isRegistered();
	        registerSteps.clickLogOutButton();
	}
	

	}
