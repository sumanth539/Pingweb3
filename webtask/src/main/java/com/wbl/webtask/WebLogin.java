package com.wbl.webtask;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebLogin {


	
	
		public static WebDriver driver;
		public Object[] expectedUrl;
		public Object[] actualUrl;
		TestBase t = new TestBase(driver);

		@Before
		public void loginPage() {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\kanpuri\\Desktop\\driver\\chromedriver.exe");

			driver = new ChromeDriver();

			driver.get("https://ping.telebu.com/login");

		}

		@Test
		public void ValidCredientials() {
			t.send("8523088073");
			t.loginButton();
			t.url();
			Assert.assertEquals(expectedUrl, actualUrl);

		}

		@Test
		public void InValidCredientials2() {
			t.send("1236547896");
			t.loginButton();
			t.url();
			Assert.assertNotEquals(expectedUrl, actualUrl);

		}

		@Test
		public void NullCredientials() {

			try {
				TestBase t = new TestBase(driver);
				t.send(null);
				t.loginButton();
				t.url();
				Assert.assertNotEquals(expectedUrl, actualUrl);

			} catch (Exception e) {

			}

		}

		@Test
		public void IntCharCreiantials() {
			t.send("789abc2312");
			t.loginButton();
			t.url();
			Assert.assertNotEquals(expectedUrl, actualUrl);

		}

		@Test
		public void Fractions() {
			t.send("998984.99");
			t.loginButton();
			t.url();

			Assert.assertNotEquals(expectedUrl, actualUrl);
		}

		@Test
		public void NumberSPecialCaracters() {
			t.send("8523496325-");
			t.loginButton();
			t.url();
			Assert.assertNotEquals(expectedUrl, actualUrl);
		}

		@Test
		public void EmptyCredientials() {
			t.send("  ");
			t.loginButton();
			t.url();

			Assert.assertNotEquals(expectedUrl, actualUrl);
		}

		@Test
		public void SpacedCredientials() {
			t.send("85234  96325");
			t.loginButton();
			t.url();

			Assert.assertNotEquals(expectedUrl, actualUrl);
		}

	}


