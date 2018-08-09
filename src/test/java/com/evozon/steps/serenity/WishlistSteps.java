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
	public void clickWishlistButton() {
		wishlistPage.clickWishlistButton();
	}
	
	@Step
	public void  removeProductFromWishlist() {
		wishlistPage.removeProductFromWishlist();
	}
	
	@Step
	public void  setQuantity(String quantity) {
		wishlistPage.setQuantity(quantity);
	}
	
	@Step
	public void addComment(String comment) {
		wishlistPage.addComment(comment);
	}
	
	@Step
	public void updateProductInfo(String comment) {
		wishlistPage.updateProductInfo();
	}
	
	@Step
	public void editProduct() {
		wishlistPage.editProduct();
	}
	
	
	
}
