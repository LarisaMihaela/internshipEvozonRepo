package com.evozon.tests;

import org.junit.runner.RunWith;

import com.evozon.ui.flowsteps.RegisterUiFlowSteps;

import net.serenitybdd.junit.runners.SerenityRunner;

@RunWith(SerenityRunner.class)
public class RegisterTest extends BaseTest {
	RegisterUiFlowSteps registerUiFlowSteps;
	
	public void registerFlowValidCredentials() {
		registerUiFlowSteps.registerWithValidCredentials();
	}
}
