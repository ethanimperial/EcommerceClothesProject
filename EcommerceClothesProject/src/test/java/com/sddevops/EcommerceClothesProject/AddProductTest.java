package com.sddevops.EcommerceClothesProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AddProductTest {
	
	 private WebDriver webDriver;		
	
  @Test
  public void checkInput() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
   
      webDriver.get("http://localhost:8090/EcommerceClothesProject/ProductDetailsServlet/dashboard");
      
      
      
      
      WebElement addProduct = webDriver.findElement(By.name("addProduct"));
      
      addProduct.click();
      
      WebElement name = webDriver.findElement(By.name("name"));
      
      WebElement image = webDriver.findElement(By.name("image"));
      
      WebElement price = webDriver.findElement(By.name("price"));
      
      WebElement category = webDriver.findElement(By.name("category"));
      
     
      
      name.sendKeys("testname");
      image.sendKeys("testimage");
      price.sendKeys("45.99");
      category.sendKeys("testcategory");
      
      WebElement save = webDriver.findElement(By.name("save"));
      
      save.click();
      
      
  }
  @BeforeTest
  public void beforeTest() {
	  
	  //Setting system properties of ChromeDriver
	  //to amend directory path base on your local file path
	  String chromeDriverDir = "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe";

	  System.setProperty("webdriver.chrome.driver", chromeDriverDir);

	  //initialize FirefoxDriver at the start of test
	  webDriver = new ChromeDriver();  
  }

  @AfterTest
  public void afterTest() {
	  
	  //Quit the ChromeDriver and close all associated window at the end of test
	  webDriver.quit();	
  }

}