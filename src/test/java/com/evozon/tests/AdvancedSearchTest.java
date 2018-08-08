package com.evozon.tests;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.evozon.steps.serenity.AdvancedSearchSteps;
import com.evozon.steps.serenity.SearchSteps;
import com.evozon.utils.Constants;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.CSV_FILES_PATH + "Test01_AdvancedSearch.csv", separator = Constants.CSV_SEPARATOR)
public class AdvancedSearchTest extends BaseTest {
	private String name, description, priceFrom, priceTo;

	@Steps
	AdvancedSearchSteps advancedSearchSteps;
	SearchSteps searchSteps;

	@Test @Ignore
	@Title("Test01_AdvancedSearch")
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
			advancedSearchSteps.clickOnSearchButton();
	}
		

}
