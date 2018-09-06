package com.evozon.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.evozon.ui.flowsteps.LoginFlowSteps;

//import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

//@RunWith(SerenityParameterizedRunner.class)

@RunWith(SerenityRunner.class)
public class LoginTest extends BaseTest {
	
	@Steps
	LoginFlowSteps loginFlowSteps;
	
	@Test
	public void madisonFlowSteps() {
		loginFlowSteps.loginWithValidCredentials();
		loginFlowSteps.logOut();
		
		//loginFlowSteps.logOut();
	}
	

}
