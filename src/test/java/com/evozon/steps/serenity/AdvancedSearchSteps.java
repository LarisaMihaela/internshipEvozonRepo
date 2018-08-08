package com.evozon.steps.serenity;

import com.evozon.pages.AdvancedSearchPage;

import net.thucydides.core.annotations.Step;

public class AdvancedSearchSteps extends AdvancedSearchPage {
		private AdvancedSearchPage advancedSearchPage; 
		@Step
		public void openPage() {
			advancedSearchPage.open();
		}
		
		@Step
		public void sendKeysToNameField(String keyword) {
			advancedSearchPage.sendKeysToNameField(keyword);
		}
		
		@Step
		public void sendKeysToDescriptionField(String description){
			advancedSearchPage.sendKeysToDescriptionField(description);
		}
		@Step
		public void sendKeysToPriceFrom(String priceFrom) {
			advancedSearchPage.sendKeysToPriceFrom(priceFrom);
		}
		@Step
		public void sendKeysToPriceTo(String priceTo) {
			advancedSearchPage.sendKeysToPriceTo(priceTo);
		}
		@Step
		public void setColorOption() {
			advancedSearchPage.setColorOption();
		}
		@Step
		public void setSizeOption() {
			advancedSearchPage.setSizeOption();
		}
		@Step
		public void setGenderOption() {
			advancedSearchPage.setGenderOption();
		}
		
}
