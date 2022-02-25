package com.sddevops.EcommerceClothesProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class UpdateProductTest {
	
	 private WebDriver webDriver;		
	
  @Test
  public void checkInput() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
      WebDriver driver=new ChromeDriver();
      driver.get("http://localhost:8090/EcommerceClothesProject/ProductDetailsServlet/edit?name=testname");
      
      
      
      
      WebElement name = driver.findElement(By.name("name"));
      
      WebElement image = driver.findElement(By.name("image"));
      
      WebElement price = driver.findElement(By.name("price"));
      
      WebElement category = driver.findElement(By.name("category"));
      
     
      
      name.sendKeys("updatename");
      image.sendKeys("https://upload.wikimedia.org/wikipedia/en/9/95/Test_image.jpg");
      price.sendKeys("22.99");
      category.sendKeys("updatecategory");
      
      WebElement save = driver.findElement(By.name("save"));
      
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