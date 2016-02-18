package com.tsc.selenium;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.CoreMatchers;
import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegSuccess {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://newtours.demoaut.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLoginSuccess() throws Exception {
    String username = "test"+ rand(10000, 99999);
	
	driver.get(baseUrl + "/mercuryregister.php");
    driver.findElement(By.id("email")).sendKeys(username);
    driver.findElement(By.name("password")).sendKeys("123");
    driver.findElement(By.name("confirmPassword")).sendKeys("123");
    driver.findElement(By.name("register")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.name("userName")).sendKeys(username);
    driver.findElement(By.name("password")).sendKeys("123");
    driver.findElement(By.name("login")).click();
    assertThat(driver.getCurrentUrl(), CoreMatchers.containsString("http://newtours.demoaut.com/mercuryreservation.php"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
  
  private static int rand(int min, int max) {
      try {
          Random rn = new Random();
          int range = max - min + 1;
          int randomNum = min + rn.nextInt(range);
          return randomNum;
      } catch (Exception e) {
          e.printStackTrace();
          return -1;
      }
  }
}
