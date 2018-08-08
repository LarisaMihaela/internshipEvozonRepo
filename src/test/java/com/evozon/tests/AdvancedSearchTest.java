package com.evozon.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.evozon.steps.serenity.AdvancedSearchSteps;
import com.evozon.steps.serenity.SearchSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class AdvancedSearchTest extends BaseTest {
	private String name = "dress";
	private String description = "dress";
	private String priceFrom = "0";
	private String priceTo = "400";

	@Steps
	AdvancedSearchSteps advancedSearchSteps;
	SearchSteps searchSteps;

	@Test 
		public void advancedSearchByPrice() {
			advancedSearchSteps.openPage();
			advancedSearchSteps.sendKeysToPriceFrom(priceFrom);
			advancedSearchSteps.sendKeysToPriceTo(priceTo);
			advancedSearchSteps.clickOnSearchButton();
			searchSteps.clickSortDropDown();
			searchSteps.verifyIfProductsAreSortedByPrice();
}
	
	@Test
		public void advancedSearchWithValidCredentials() {
			advancedSearchSteps.openPage();
			advancedSearchSteps.sendKeysToNameField(name);
			advancedSearchSteps.sendKeysToDescriptionField(description);
			advancedSearchSteps.sendKeysToPriceFrom(priceFrom);
			advancedSearchSteps.sendKeysToPriceTo(priceTo);
			advancedSearchSteps.setColorOption();
			advancedSearchSteps.setSizeOption();
			advancedSearchSteps.setGenderOption();
	}
		

}
