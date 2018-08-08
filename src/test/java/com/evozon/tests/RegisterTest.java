package com.evozon.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.evozon.steps.serenity.RegisterSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

	@RunWith(SerenityRunner.class)
		public class RegisterTest extends BaseTest {
		
			BaseTest bt = new BaseTest();
			private String firstName = "John";
			private String middleName = "Jr.";
			private String lastName = "Doe";
			private String password = "johndoetest";
	
	@Steps
		RegisterSteps registerSteps;
	
	@Test
		public void registerWithValidCredentials() {
			registerSteps.openPage();
			registerSteps.setFirstNameField(firstName);
			registerSteps.setMiddleNameField(middleName);
	        registerSteps.setLastNameField(lastName);
	        registerSteps.setEmailField(bt.getSaltString()+"@gmail.com");
	        registerSteps.setPasswordField(password);
	        registerSteps.setConfirmedPassword(password);
	        registerSteps.clickRegisterButton();
	        //registerSteps.isRegistered(firstName);
	        registerSteps.clickLogOutButton();
	}
	}
