package com.evozon.ui.flowsteps;

import org.junit.Ignore;
import org.junit.Test;

import com.evozon.steps.serenity.SearchSteps;
import com.evozon.utils.Constants;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

public class SearchPageUiFlowStep {
	String keywordToSearch;
	String invalidKeywordToSearch = "234434";
	
	@Steps
	SearchSteps searchSteps;
	
	@Step @Title("02_SearchTest")
	public void searchWithValidKeyword() {
		searchSteps.openPage();
		searchSteps.sendKeysToSearchBox(Constants.VALID_KEYWORD_TO_SEARCH);
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
