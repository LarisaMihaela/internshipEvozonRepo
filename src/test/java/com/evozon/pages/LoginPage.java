package com.evozon.pages;

import static org.junit.Assert.assertTrue;

import com.evozon.utils.Constants;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl(Constants.BASE_URL + "/customer/account/login/")
public class LoginPage extends PageObject{
	
	@FindBy(css = "#email")
	private WebElementFacade emailField;
	
	@FindBy(css = "#pass")
	private WebElementFacade passwordField;
	
	@FindBy(css = ".welcome-msg")
	private WebElementFacade welcomeMessage;
	
	@FindBy(css = "#send2")
	private WebElementFacade loginButton;
	
	@FindBy(css = "#header-account>.links>ul>.last")
	private WebElementFacade logoutButton;
	
	@FindBy(css = ".skip-link.skip-account.skip-active>.label")
	private WebElementFacade accountHeader;
	
	@FindBy(css= "#advice-required-entry-email")
	private WebElementFacade requiredEmailFieldValidationAdvice;
	
	@FindBy(css= "#advice-validate-password-pass")
	private WebElementFacade passwordTooShortValidationAdvice;
	
	@FindBy(css = "#advice-required-entry-pass")
	private WebElementFacade requiredPasswordFieldValidationAdvice;
	
	@FindBy(css = ".error-msg")
	private WebElementFacade errorLoginMessage;
	
	public void setEmailField(String email) {
		typeInto(emailField, email);
	}
	
	public void setPasswordField(String password) {
		typeInto(passwordField, password);
	}
	
	public void isLoggedIn(String name) {
		 assertTrue(welcomeMessage.getText().toLowerCase().contains(name));
		    }
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void clickAccountHeader() {
		accountHeader.click();
	}
	
	public void clickLogoutButton() {
		logoutButton.click();
	}
	
	public void getInvalidLoginMessage() {
		errorLoginMessage.getText();
	}
	
	public void checkValidationAdvice(String result) {
		switch(result) {
		case("PasswordTooShort"):
			assertTrue(passwordTooShortValidationAdvice.getText().equalsIgnoreCase("Please enter 6 or more characters without leading or trailing spaces."));
			break;
		case("RequiredEmailField"):
			assertTrue(requiredEmailFieldValidationAdvice.getText().equalsIgnoreCase("This is a required field."));
			break;
		case("RequiredPasswordField"):
			assertTrue(requiredPasswordFieldValidationAdvice.getText().equalsIgnoreCase("This is a required field."));
		case ("invalidCredentials"):
			getInvalidLoginMessage();
             break;
		//default
		
		}
	}
	
	
	
}
