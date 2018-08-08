package com.evozon.steps.serenity;

import com.evozon.pages.LoginPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class LoginSteps extends LoginPage{
	private LoginPage loginPage;
	
	@Step
	public void openPage() {
		loginPage.open();
		}
	
	@Step
	public void setEmailNameField(String email) {
		loginPage.setEmailField(email);
	}
	
	@Step
	public void setPasswordField(String password) {
		loginPage.setPasswordField(password);
	}
	
	@Step
	public void clickLoginButton() {
		loginPage.clickLoginButton();
	};
	
	@Step
	public void isLoggedIn(String name) {
		loginPage.isLoggedIn(name);
	}
	
	@Step
	public void clickLogoutButton() {
		loginPage.clickLogoutButton();
	}
	
	@Step
	public void clickAccountHeader() {
		loginPage.clickAccountHeader();
	}
	
}
