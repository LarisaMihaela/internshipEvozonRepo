package com.evozon.pages;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;

import  com.evozon.utils.*;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;



@DefaultUrl(Constants.BASE_URL + "/customer/account/create/")

public class RegisterPage extends PageObject{

	
	
	@FindBy(css = "#firstname")
	private WebElementFacade firstNameField;

	@FindBy(css = "#middlename")
	private WebElementFacade middleNameField;

	@FindBy(css = "#lastname")
	private WebElementFacade lastNameField;

	@FindBy(css = "#email_address")
	private WebElementFacade emailField;

	@FindBy(css = "#password")
	private WebElementFacade passwordField;

	@FindBy(css = "#confirmation")
	private WebElementFacade confirmedPassword;

	@FindBy(css = "button[title='Register")
	private WebElementFacade registerButton;

	@FindBy(css = ".skip-account .label")
	private WebElementFacade logOutButton;
	
	@FindBy(css = ".hello")
	private WebElementFacade searchTitlePage;
	
	@FindBy(css = ".success-msg")
	private WebElementFacade successMessage;



	public void setFirstNameField(String firstName) {
		typeInto(firstNameField, firstName);
	}
	public void setMiddleNameField(String middleName) {
		typeInto(middleNameField, middleName);
	}

	public void setLastNameField(String lastName) {
		typeInto(lastNameField, lastName);
	}

	public void setEmailField(String email) {
		typeInto(emailField, email);
	}
	public void setPasswordField(String password) {
		typeInto(passwordField, password);
	}

	public void setConfirmedPassword(String password) {
		typeInto(confirmedPassword, password);
	}
	public void clickRegisterButton() {
		registerButton.click();
	}
	public void clickLogOutButton() {
		logOutButton.click();
	}
	
	public void isRegistered() {
    	assertTrue(successMessage.getText().contains("Thank you"));
	    }
	
	


}
