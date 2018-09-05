package com.evozon.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


import net.thucydides.core.annotations.Managed;

public class BaseTest {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	
	@Before
	public void setUp() {
		driver.manage().window().maximize();
	}
	
	@After
	public void closeDriver() {
		driver.close();
	}
	
}
