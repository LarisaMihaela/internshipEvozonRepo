package com.evozon.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.evozon.steps.api.flowsteps.ApiLoginFlowSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class LoginApiTest extends BaseTest{
	@Steps
	ApiLoginFlowSteps apiloginFlowSteps;
	
	@Test
	public void loginApiTest() throws Exception {
		apiloginFlowSteps.loginApi();
	}

}
