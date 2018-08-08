package com.evozon.steps.serenity;


import com.evozon.pages.RegisterPage;

//import junit.framework.Assert;
import net.thucydides.core.annotations.Step;

public class RegisterSteps extends RegisterPage {
	private RegisterPage registerPage;

	@Step
	public void openPage() {
		registerPage.open();
	}
	@Step
	public void setFirstNameField(String firstName) {
		registerPage.setFirstNameField(firstName);
	}
	@Step
	public void setMiddleNameField(String middleName) {
		registerPage.setMiddleNameField(middleName);
	}
	@Step
	public void setLastNameField(String lastName) {
		registerPage.setLastNameField(lastName);
	}
	@Step
	public void setEmailNameField(String email) {
		registerPage.setEmailField(email);
	}
	@Step
	public void setPasswordField(String password) {
		registerPage.setPasswordField(password);
	}
	@Step
	public void setConfirmedPassword(String password) {
		registerPage.setConfirmedPassword(password);
	}
	@Step
	public void clickRegisterButton() {
		registerPage.clickRegisterButton();
	};
	public void isRegistered(String name) {
		registerPage.isRegistered(name);
	}
	// Assert.assertTrue(accountPage.isLoggedIn(firstName));

}
