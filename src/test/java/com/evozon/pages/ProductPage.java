package com.evozon.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.evozon.utils.Constants;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
@DefaultUrl(Constants.BASE_URL)
public class ProductPage extends PageObject {

		Random rnd = new Random();

		@FindBy(css = ".item.last")
		private List<WebElement> randomProduct;
		
		@FindBy(css = ".products-grid.products-grid--max-3-col.first.last.odd")
		private WebElementFacade gridProduct;
		
		@FindBy(css = ".product-image")
		private WebElementFacade productImage;
		
		@FindBy(css = ".input-text.qty")
		private WebElementFacade inputTextQuantity;
		
		@FindBy(css = ".input-box>select[name = \"super_attribute[180]\"]")
		private WebElementFacade sizeOptionElement;
		
		@FindBy(css = ".add-to-cart-buttons>button.btn-cart")
		private WebElementFacade addToCartButton;
		
		
		public WebElement getRandomProduct() {
	        List<WebElement> productsList = (List<WebElement>) randomProduct;
	        Random rnd = new Random();
	        return productsList.get(rnd.nextInt(productsList.size()));
	    }
		
		public void clickOnProduct() {	
			productImage.click();

		}
		
		public void clearQuantityField() {
			
			inputTextQuantity.clear();
		}
		
		public void setQuantity(String quantityToSend) {
			if(inputTextQuantity.isDisplayed()) {
			inputTextQuantity.sendKeys(quantityToSend);
			}
		}
		
		public void selectRandomSize() {
			if(sizeOptionElement.isDisplayed()) {
			WebElement sizeOptions = sizeOptionElement;
			Select oSelect = new Select(sizeOptions);
			List<WebElement> allOptions = oSelect.getOptions();
			for (int i = 0; i < allOptions.size(); i++) {
				System.out.println(allOptions.get(i));
			}
			oSelect.selectByIndex(rnd.nextInt());
			System.out.println(oSelect.getFirstSelectedOption());
			}
		}
		
		public void addProductToCart() {
			addToCartButton.click();
		}
		
//		public boolean getProductList() {
//			List<WebElementFacade> productList = 
//		}
}
