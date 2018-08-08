package com.evozon.tests;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.evozon.steps.serenity.LoginSteps;
import com.evozon.steps.serenity.SearchSteps;
import com.evozon.steps.serenity.WishlistSteps;
import com.evozon.utils.Constants;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.CSV_FILES_PATH + "Test01_LoginWithValidCredentials.csv", separator = Constants.CSV_SEPARATOR)
public class WishlistTest extends BaseTest {
	String keyword = "music";
	String email, password;
	
	@Steps
	WishlistSteps wishlistSteps;
	@Steps
	SearchSteps searchSteps;
	@Steps
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
