package com.evozon.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import com.evozon.utils.*;


@DefaultUrl(Constants.BASE_URL + "/catalogsearch/advanced/")
public class AdvancedSearchPage extends PageObject {
	
//	@FindBy(css = "a[title='Advanced Search']")
//	private WebElementFacade advancedSearchLink;
	
	@FindBy(css = "#price")
	private WebElementFacade priceFromField;
	
	@FindBy(css = "#price_to")
	private WebElementFacade priceToField;
	
	@FindBy(css = ".buttons-set>button")
	private WebElementFacade searchButton;
	
	@FindBy(css = "#name")
	private WebElementFacade nameField;
	
	@FindBy(css = "#description")
	private WebElementFacade descriptionField;
	
	@FindBy(css = "#color>:nth-child(3)")
	private WebElementFacade colorOptionBrown;
	
	@FindBy(css = "#size>:nth-child(7)")
	private WebElementFacade sizeOptions;
	
	@FindBy(css = "#gender>:nth-child(1)")
	private WebElementFacade genderOptionFemale;
	

	 
//	public void clickOnAdvancedSearch(String advancedSearchLink) {
//		searchButton.click();
//	}
	
	public void sendKeysToNameField(String keyword) {
		typeInto(nameField, keyword);
	}
	
	public void sendKeysToDescriptionField(String description) {
		typeInto(descriptionField, description);
	}
	
	public void setColorOption() {
		colorOptionBrown.click();
	}
	
	public void setSizeOption() {
		sizeOptions.click();
	}
	
	public void setGenderOption() {
		genderOptionFemale.click();
	}
	
	public void sendKeysToPriceFrom(String priceFrom) {
		typeInto(priceFromField, priceFrom);
	}
	
	public void sendKeysToPriceTo(String priceTo) {
		typeInto(priceToField, priceTo);
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	
	
	
}