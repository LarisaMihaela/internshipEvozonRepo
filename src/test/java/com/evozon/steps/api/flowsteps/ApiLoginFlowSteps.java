package com.evozon.steps.api.flowsteps;

import com.evozon.steps.api.ApiLoginSteps;

import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;

public class ApiLoginFlowSteps {
	@Steps
    ApiLoginSteps apiLoginSteps;
	
	@StepGroup
	public void loginApi() throws Exception {
		apiLoginSteps.apiLoginAsUser();
	}
}
