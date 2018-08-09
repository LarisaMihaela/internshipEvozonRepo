package com.evozon.pages;

import com.evozon.utils.Constants;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl(Constants.BASE_URL + "//wishlist//")
public class WishlistPage extends PageObject {
	@FindBy(css = ".link-wishlist")
	private WebElementFacade addToWishlistButton;
	
	@FindBy(css = ".input-text.qty")
	private WebElementFacade productQuantity;
	
	@FindBy(css = ".wishlist-cell1.customer-wishlist-item-info>textarea")
	private WebElementFacade commentField;
	
	@FindBy(css = ".item-manage>.button.btn-update.button-secondary")
	private WebElementFacade updateProductInfo;
	
	@FindBy(css = ".wishlist-cell5.customer-wishlist-item-remove.last")
	private WebElementFacade removeProductFromWishlist;

	@FindBy(css = ".link-edit.button.button-secondary")
	private WebElementFacade editButton;
	
	
	public void setQuantity(String quantity) {
		typeInto(productQuantity, quantity);
	}
	
	public void addComment(String comment) {
		typeInto(commentField, comment);
	}
	
	public void updateProductInfo() {
		updateProductInfo.click();
	}
	
	public void removeProductFromWishlist() {
		removeProductFromWishlist.click();
	}
	
	public void editProduct() {
		editButton.click();
	}
	
	public void clickWishlistButton() {
		addToWishlistButton.click();
	}
	

	
}
