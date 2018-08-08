package com.evozon.pages;

import java.util.List;


import java.util.Random;

import org.openqa.selenium.WebElement;

import com.evozon.utils.Constants;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
@DefaultUrl(Constants.BASE_URL)
public class ProductPage extends PageObject {
	
		Random rnd = new Random();

		@FindBy(css = ".link-wishlist")
		private WebElementFacade addToWishlistButton;
		
		@FindBy(css = ".item.last")
		private List<WebElement> randomProduct;
		
		
		@FindBy(css = ".products-grid.products-grid--max-3-col.first.last.odd")
		private WebElementFacade gridProduct;
		
		
		
		public WebElement getRandomProduct() {
	        List<WebElement> productsList = (List<WebElement>) randomProduct;
	        Random rnd = new Random();
	        return productsList.get(rnd.nextInt(productsList.size()));
	    }
		
		public void clickWishlistButton() {
			addToWishlistButton.click();
		}
		
		
}
