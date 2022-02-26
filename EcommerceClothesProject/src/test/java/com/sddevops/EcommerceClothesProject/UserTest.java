package com.sddevops.EcommerceClothesProject;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class UserTest {
	// declare Selenium WebDriver
	private WebDriver webDriver;
	private String name;

	public String generateRandomName(int length) {
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String randomString = sb.toString();
		return randomString;
	}
	
	String email = generateRandomName(9) + "@gmail.com";
	String password = generateRandomName(2);

	@Test (priority = 0)
	public void checkRegister() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8090/EcommerceClothesProject/login.jsp");

		// Find button to access register page and click
		webDriver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[3]/a")).click();

		// Find input elements for each input
		WebElement registerUsername = webDriver.findElement(By.xpath("/html/body/div/div/div[2]/form/input[1]"));
		WebElement registerPassword = webDriver.findElement(By.xpath("/html/body/div/div/div[2]/form/input[2]"));
		WebElement registerEmail = webDriver.findElement(By.xpath("/html/body/div/div/div[2]/form/input[3]"));
		WebElement registerAddress = webDriver.findElement(By.xpath("/html/body/div/div/div[2]/form/input[4]"));

		// Input values into the empty element
		registerUsername.sendKeys(generateRandomName(9));
		registerPassword.sendKeys(password);
		registerEmail.sendKeys(email);
		registerAddress.sendKeys(generateRandomName(9));

		// Click on button to register new account
		webDriver.findElement(By.xpath("/html/body/div/div/div[2]/form/div/button")).click();

		// Move to login page
		webDriver.findElement(By.xpath("/html/body/a")).click();

		// Check if account managed to register and move to login page
		Assert.assertEquals(webDriver.getTitle(), "Login");
	}

	@Test (priority = 1)
	public void checkLogin() {
		// Find input element for email
		WebElement we = webDriver.findElement(By.id("email"));
		// Find input element for password
		WebElement me = webDriver.findElement(By.id("password"));

		// Input given email and password for login
		we.sendKeys(email);
		me.sendKeys(password);

		// Find login button and click
		webDriver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[3]/button")).click();

		// Check that we have reached the next page after logging in
		Assert.assertEquals(webDriver.getTitle(), "Insert title here");

		// Assert.assertEquals(we.getAttribute("role"), "contentinfo");
	}

	@Test (priority = 2)
	public void checkUpdate() {
		// Find button for profile and click
		//webDriver.findElement(By.xpath("/html/body/nav/div/div/ul/li[3]/a")).click();
		
		//Move to profile page
		webDriver.navigate().to("http://localhost:8090/EcommerceClothesProject/UserServlet/dashboard");

		// Assert the title to check that we are indeed in the correct website
		Assert.assertEquals(webDriver.getTitle(), "My account");

		// Find button to edit profile and click
		webDriver.findElement(By.xpath("/html/body/div/div/table/tbody/tr/td[4]/a[1]")).click();

		// Generates random input for editing
		name = generateRandomName(9); // 9 Characters long

		// Find the different input elements
		WebElement newName = webDriver.findElement(By.xpath("/html/body/div/div/div/form/fieldset[1]/input"));

		// Input the randomized name to edit the username
		newName.sendKeys(Keys.CONTROL + "A");
		newName.sendKeys(name);

		// Click on the save button
		webDriver.findElement(By.xpath("/html/body/div/div/div/form/button")).click();

		// Check whether page was redirected after editing
		Assert.assertEquals(webDriver.getTitle(), "My account");

	}

	@Test (priority = 3)
	public void checkDelete() {
		// Find button for profile and click
		webDriver.findElement(By.xpath("/html/body/div/div/table/tbody/tr/td[4]/a[2]")).click();
	}

	@BeforeTest
	public void beforeTest() {
		// Setting system properties of ChromeDriver
		// to amend directory path base on your local file path
		String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", chromeDriverDir);

		// initialize FirefoxDriver at the start of test
		webDriver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		// Quit the ChromeDriver and close all associated window at the end of test
		webDriver.quit();
	}

}