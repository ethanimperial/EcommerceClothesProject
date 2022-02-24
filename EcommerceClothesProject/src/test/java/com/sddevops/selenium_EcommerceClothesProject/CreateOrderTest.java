package com.sddevops.selenium_EcommerceClothesProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class CreateOrderTest {
	
  @Test
  public void checkInput() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
      WebDriver driver=new ChromeDriver();
      
      driver.get("http://localhost:8090/EcommerceClothesProject/AddToCartServlet?id=60");
      driver.get("http://localhost:8090/EcommerceClothesProject/AddToCartServlet?id=61");
      driver.get("http://localhost:8090/EcommerceClothesProject/AddToCartServlet?id=62");
      
      driver.get("http://localhost:8090/EcommerceClothesProject/cart.jsp");
      
      
  
      driver.get("http://localhost:8090/EcommerceClothesProject/QuantityServlet?action=inc&id=60");
      
      driver.get("http://localhost:8090/EcommerceClothesProject/QuantityServlet?action=inc&id=60");
      
      driver.get("http://localhost:8090/EcommerceClothesProject/QuantityServlet?action=dec&id=60");
      
      

      driver.get("http://localhost:8090/EcommerceClothesProject/RemoveFromCartServlet?id=61");
    
     
      WebElement check = driver.findElement(By.name("check"));
      
      check.click();
      
      
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
