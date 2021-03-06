package com.evozon.tests;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.evozon.ui.flowsteps.LoginFlowSteps;
import com.evozon.ui.flowsteps.ProductPageFlowSteps;
import com.evozon.ui.flowsteps.RegisterUiFlowSteps;
import com.evozon.ui.flowsteps.SearchPageUiFlowStep;

//import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

//@RunWith(SerenityParameterizedRunner.class)

@RunWith(SerenityRunner.class)
public class UserFlowSteps extends BaseTest {
	
	@Steps
	LoginFlowSteps loginFlowSteps;
	@Steps
	RegisterUiFlowSteps registerFlowSteps;
	@Steps
	SearchPageUiFlowStep searchPageUiFlowSteps;
	@Steps
	ProductPageFlowSteps productPageFlowSteps;
	
	@Test @Ignore
	public void registerUser() {
		registerFlowSteps.registerWithValidCredentials();
	}
	
	@Test
	public void buyProduct() {
		
		loginFlowSteps.loginWithValidCredentials();
		searchPageUiFlowSteps.searchWithValidKeyword();
		productPageFlowSteps.setProductDetails();
		loginFlowSteps.logOut();

	}
	

}
