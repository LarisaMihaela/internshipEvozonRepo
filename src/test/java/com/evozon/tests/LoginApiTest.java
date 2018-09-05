package com.evozon.tests;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.evozon.tests.BaseTest;
import com.evozon.steps.api.AbstractApiSteps;
import com.evozon.steps.api.flowsteps.ApiLoginFlowSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class LoginApiTest extends BaseTest{
	@Steps
	ApiLoginFlowSteps apiloginFlowSteps;
	@Steps
	AbstractApiSteps aa;
	
	@Test
	public void loginApiTest() {
		apiloginFlowSteps.loginApi();
	}
}
