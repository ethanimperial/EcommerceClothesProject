package com.sddevops.selenium_EcommerceClothesProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AddFeedbackTest {

  @Test
  public void checkInput() {
      System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
      WebDriver driver=new ChromeDriver();
      driver.get("http://localhost:8090/EcommerceClothesProject/R2FeedbackServlet/dashboard");


      


      WebElement addFeedback = driver.findElement(By.name("Feedback"));

      addFeedback.click();
      Assert.assertEquals(driver.getTitle(), "Enter your Feedback here!");

      WebElement feedback = driver.findElement(By.name("Feedback"));

      

      feedback.sendKeys("M is the best");
     

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
