package com.evozon.tests;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.evozon.steps.serenity.SearchSteps;
import com.evozon.utils.Constants;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.CSV_FILES_PATH + "02_SearchTest.csv", separator = Constants.CSV_SEPARATOR)
public class SearchTest extends BaseTest {
	String keywordToSearch;
	String invalidKeywordToSearch = "234434";
	
	@Steps
	SearchSteps searchSteps;
	
	@Test
	@Title("02_SearchTest")
	public void searchWithValidKeyword() {
		searchSteps.openPage();
		searchSteps.sendKeysToSearchBox(keywordToSearch);
		searchSteps.clickOnSearchButton();
		searchSteps.clickSortDropDown();
		searchSteps.verifyIfProductsAreSortedByPrice();
		//searchSteps.compareExpectedAndActualProductsNumber(); 
		searchSteps.checkIfKeywordIsDisplayedOnPage();
	}
	
	@Test @Ignore
	public void searchWithInvalidKeyword() {
		searchSteps.openPage();
		searchSteps.sendKeysToSearchBox(invalidKeywordToSearch);
		searchSteps.clickOnSearchButton();

	}
}
