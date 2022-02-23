package com.sddevops.selenium_EcommerceClothesProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AddProductTest {
	
  @Test
  public void checkInput() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
      WebDriver driver=new ChromeDriver();
      driver.get("http://localhost:8090/EcommerceClothesProject/ProductDetailsServlet/dashboard");
      
      
      
      
      WebElement addProduct = driver.findElement(By.name("addProduct"));
      
      addProduct.click();
      
      WebElement name = driver.findElement(By.name("name"));
      
      WebElement image = driver.findElement(By.name("image"));
      
      WebElement price = driver.findElement(By.name("price"));
      
      WebElement category = driver.findElement(By.name("category"));
      
     
      
      name.sendKeys("testname");
      image.sendKeys("testimage");
      price.sendKeys("45.99");
      category.sendKeys("testcategory");
      
      WebElement save = driver.findElement(By.name("save"));
      
      save.click();
      
      
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
