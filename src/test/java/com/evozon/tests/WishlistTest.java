package com.evozon.tests;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.evozon.steps.serenity.LoginSteps;
import com.evozon.steps.serenity.SearchSteps;
import com.evozon.steps.serenity.WishlistSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class WishlistTest extends BaseTest {
	String keyword = "music";
	String email = "glarisamihaela@gmail.com";
	String password = "serenitytest";
	@Steps
	WishlistSteps wishlistSteps;
	SearchSteps searchSteps;
	LoginSteps loginSteps;
	
	
	@Test 
	public void addRandomProductToWishlistWithLogin() {
		loginSteps.openPage();
		loginSteps.setEmailNameField(email);
		loginSteps.setPasswordField(password);
		loginSteps.clickLoginButton();
		searchSteps.sendKeysToSearchBox(keyword);
		searchSteps.clickOnSearchButton();
		wishlistSteps.getRandomProduct();
		wishlistSteps.clickWishlistButton();
	}
	
	
	@Test @Ignore
	public void addRandomProductToWishlistWithoutLogin() {
		wishlistSteps.openPage();
		searchSteps.sendKeysToSearchBox(keyword);
		searchSteps.clickOnSearchButton();
		wishlistSteps.getRandomProduct();
		wishlistSteps.clickWishlistButton();
	}
}
