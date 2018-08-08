package com.evozon.steps.serenity;

import org.openqa.selenium.WebElement;

import com.evozon.pages.ProductPage;

import net.thucydides.core.annotations.Step;

public class WishlistSteps {
	private ProductPage productPage;
	
	@Step
	public void openPage() {
		productPage.open();
	}
	
	@Step
	public WebElement getRandomProduct() {
		return productPage.getRandomProduct();
	}
	
	@Step
	public void clickWishlistButton() {
		productPage.clickWishlistButton();
	}
	
}
