package com.evozon.tests;

import org.junit.runner.RunWith;

import com.evozon.steps.serenity.SearchSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom(value = Constants.CSV_FILES_PATH + "02_SearchTest.csv", separator = Constants.CSV_SEPARATOR)
public class SearchTest extends BaseTest {
	//String keywordToSearch;
	//String invalidKeywordToSearch = "234434";
	
	@Steps
	SearchSteps searchSteps;
	
	@Step
	@Title("02_SearchTest")
	public void searchWithValidKeyword() {
	}
	
}
