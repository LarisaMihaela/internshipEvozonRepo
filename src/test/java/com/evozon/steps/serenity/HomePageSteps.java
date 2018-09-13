package com.evozon.steps.serenity;

import com.evozon.pages.HomePage;

import net.thucydides.core.annotations.Step;

public class HomePageSteps extends HomePage {
		private HomePage homePage;
		
		@Step
		public void openPage() {
			homePage.open();
			}
}
