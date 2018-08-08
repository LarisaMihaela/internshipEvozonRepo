package com.evozon.steps.serenity;

import org.openqa.selenium.WebElement;

import com.evozon.pages.ProductPage;
import com.evozon.pages.WishlistPage;

import net.thucydides.core.annotations.Step;

public class WishlistSteps extends WishlistPage {
	private ProductPage productPage;
	private WishlistPage wishlistPage;
	
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
		wishlistPage.clickWishlistButton();
	}
	
}
