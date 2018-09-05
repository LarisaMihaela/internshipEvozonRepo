package com.evozon.steps.api;

import com.evozon.tools.entities.Login;
import com.evozon.tools.entities.User;
import com.tools.factories.LoginFactory;
import com.tools.utils.InstanceUtils;
import com.tools.utils.SerenitySessionUtils;
import  com.evozon.utils.ApiUrlConstants;
import com.evozon.utils.SerenityKeyConstants;

import net.thucydides.core.annotations.Step;

public class ApiLoginSteps extends AbstractApiSteps {

	private static final long serialVersionUID = 1L;

	@Step
	public void loginAsUser() {
		Login loginRequest = LoginFactory.getLoginInstance();
		User userResponse = createResource(ApiUrlConstants.LOGIN, loginRequest, User.class);

		loginRequest.setUser((User) InstanceUtils.mergeObjects(loginRequest.getUser(), userResponse));
		AbstractApiSteps.extraHeaders.put("Authorization", "Basic " + userResponse.getAuthenticationToken());

		SerenitySessionUtils.putOnSession(SerenityKeyConstants.USER, loginRequest.getUser());
	}
}
