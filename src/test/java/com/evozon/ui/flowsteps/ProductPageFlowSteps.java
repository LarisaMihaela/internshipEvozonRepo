package com.evozon.ui.flowsteps;

import com.evozon.steps.serenity.ProductSteps;

import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;

public class ProductPageFlowSteps {
	@Steps
	ProductSteps productSteps;
	
	@StepGroup
	public void setProductDetails() {
		productSteps.clickOnProduct();
		productSteps.clearQuantityField();
		productSteps.setQuantity("1");
		//productSteps.selectRandomSize();
		productSteps.addProductToCart();
	}
}
