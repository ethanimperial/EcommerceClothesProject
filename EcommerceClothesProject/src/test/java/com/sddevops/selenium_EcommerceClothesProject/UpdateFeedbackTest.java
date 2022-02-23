package com.sddevops.selenium_EcommerceClothesProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class UpdateFeedbackTest {

  @Test
  public void checkInput() {
      System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
      WebDriver driver=new ChromeDriver();
      driver.get("http://localhost:8090/EcommerceClothesProject/R2FeedbackServlet/edit?name=18");


      


      WebElement edit = driver.findElement(By.name("feedback"));

      edit.click();
      


      edit.sendKeys("M is the worst student");
     

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
