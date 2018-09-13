package com.evozon.steps.serenity;

import org.openqa.selenium.WebElement;

import com.evozon.pages.ProductPage;

import net.thucydides.core.annotations.Step;

public class ProductSteps extends ProductPage {
	private ProductPage productPage;
	
	@Step
	
	public void openPage() {
		productPage.open();
	}
	
	@Step
	public void clickOnProduct() {
		productPage.clickOnProduct();
	}
	
	@Step
	public void clearQuantityField() {
		productPage.clearQuantityField();
	}
	
	@Step
	public void setQuantity(String quantityToSend) {
		productPage.setQuantity(quantityToSend);
	}
	
	@Step
	public void selectRandomSize() {
		productPage.selectRandomSize();
	}
	
	@Step
	public WebElement getRandomProduct() {
		return productPage.getRandomProduct();
	}
	
	@Step
	public void clickAddButton() {
		productPage.addProductToCart();
	}
}
