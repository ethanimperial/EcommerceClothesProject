package com.sddevops.EcommerceClothesProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class CreateOrderTest {
	
	 private WebDriver webDriver;		
	
  @Test
  public void checkInput() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
   
      
      webDriver.get("http://localhost:8090/EcommerceClothesProject/AddToCartServlet?id=60");
      webDriver.get("http://localhost:8090/EcommerceClothesProject/AddToCartServlet?id=61");
      webDriver.get("http://localhost:8090/EcommerceClothesProject/AddToCartServlet?id=62");
      
      webDriver.get("http://localhost:8090/EcommerceClothesProject/cart.jsp");
      
      
  
      webDriver.get("http://localhost:8090/EcommerceClothesProject/QuantityServlet?action=inc&id=60");
      
      webDriver.get("http://localhost:8090/EcommerceClothesProject/QuantityServlet?action=inc&id=60");
      
      webDriver.get("http://localhost:8090/EcommerceClothesProject/QuantityServlet?action=dec&id=60");
      
      

      webDriver.get("http://localhost:8090/EcommerceClothesProject/RemoveFromCartServlet?id=61");
    
     
      WebElement check = webDriver.findElement(By.name("check"));
      
      check.click();
      
      
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
