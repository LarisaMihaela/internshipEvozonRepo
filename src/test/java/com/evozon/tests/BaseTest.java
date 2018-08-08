package com.evozon.tests;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


import net.thucydides.core.annotations.Managed;

public class BaseTest {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	@Before
	public void setUp() {
		driver.manage().window().maximize();
	}
	
	@After
	public void closeDriver() {
		driver.close();
	}
	
}
