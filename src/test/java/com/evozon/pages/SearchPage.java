package com.evozon.pages;
import com.evozon.utils.*;

import junit.framework.Assert;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;



@DefaultUrl(Constants.BASE_URL)

public class SearchPage extends PageObject{


	@FindBy(css = "#search")
	private WebElementFacade searchField;

	@FindBy(css = ".button.search-button")
	private WebElementFacade searchButton;

	@FindBy(css = ".count-container>p>strong")
	private WebElementFacade productCounter;

	@FindBy(css =".products-grid.products-grid--max-3-col.first.last.odd .item.last")
	private WebElementFacade numberOfProductsDisplayed;

	@FindBy(css = ".sort-by>select")
	private WebElementFacade sortByDropDown;

	@FindBy(css = ".page-title")
	private WebElementFacade searchTitlePage;

	public void sendKeysToSearchBox(String keyword) {
		typeInto(searchField, keyword);
	}
	@FindBy(css = ".price-box")
	private List<WebElement> productPricesBox;
	
	@FindBy(css = ".note-msg")
	private WebElement noteMessage;




	public void clickSearchButton() {
		searchButton.click();
	}

	public int getExpectedProductsNumber() {
		//	    	String countProducts = driver.findElement(productCounter).getText();
		String countProductsNumber=productCounter.getText().split(" ")[0];
		return Integer.parseInt(countProductsNumber);
	}

	public int getActualProductsNumber() {
		@SuppressWarnings("unchecked")
		List<WebElement> productsDisplayed = (List<WebElement>) numberOfProductsDisplayed;
		int productsDisplayedSize = productsDisplayed.size();
		return productsDisplayedSize;
	}

	public void compareExpectedAndActualProductsNumber() {
		assertEquals(getExpectedProductsNumber(),getActualProductsNumber());
	}

	public void clickSortDropDown() {
		WebElement dropDownOptions = sortByDropDown;
		Select dropDownSelect = new Select(dropDownOptions);	   
		List<WebElement> allOptions = dropDownSelect.getOptions();
		for (int i = 0; i < allOptions.size(); i++) {
			System.out.println(allOptions.get(i));
		}
		System.out.println(allOptions.size()); 
		dropDownSelect.selectByIndex(2);

	}

	public void checkIfKeywordIsDisplayedOnPage() {
		WebElement keywordIsDisplayed = searchTitlePage;
		assertTrue(keywordIsDisplayed.getText().toLowerCase().contains("glasses"));
	}


	Boolean ascendingCheck(List<Double> productsPriceList){ 
		boolean isAscendingSorted=false;
		for (int i = 0; i < productsPriceList.size()-1; i++) {
			if (productsPriceList.get(i) <= productsPriceList.get(i+1)) {
				isAscendingSorted=true;
				break;
			}       
		}
		return isAscendingSorted;
	}

	@SuppressWarnings("deprecation")
	public void verifyIfProductsAreSortedByPrice() {

		List<Double> productsPriceList = new ArrayList<Double>();
		for (WebElement productPrices : productPricesBox) {
			System.out.println(ascendingCheck(productsPriceList));
			productsPriceList.add(Double.parseDouble(productPrices.getText().substring(1)));
			System.out.println();
		}
		if(!ascendingCheck(productsPriceList)){
			Assert.fail("Not in ascending order");
		}



	}
















}
