package com.evozon.steps.serenity;

import com.evozon.pages.SearchPage;

import net.thucydides.core.annotations.Step;

public class SearchSteps extends SearchPage {
	private SearchPage searchPage;
	
	@Step
	public void openPage() {
		searchPage.open();
	}
	
	@Step
	public void sendKeysToSearchBox(String keyword) {
		searchPage.sendKeysToSearchBox(keyword);
	}
	
	@Step
	public void clickOnSearchButton() {
		searchPage.clickSearchButton();
	}
	
	@Step
	public int getExpectedProductsNumber() {
		return searchPage.getExpectedProductsNumber();
	}
	
	@Step
	public int getActualProductsNumber() {
		return searchPage.getActualProductsNumber();
	}
	
	@Step
	public void compareExpectedAndActualProductsNumber() {
		searchPage.compareExpectedAndActualProductsNumber();
	}
	
	@Step
	 public void clickSortDropDown() {
		searchPage.clickSortDropDown();
	 }
	 
	@Step
	 public void checkIfKeywordIsDisplayedOnPage() {
		searchPage.checkIfKeywordIsDisplayedOnPage();
	 }

	
	@Step
	 public void verifyIfProductsAreSortedByPrice() {
		searchPage.verifyIfProductsAreSortedByPrice();
	}
	
	
	
}
