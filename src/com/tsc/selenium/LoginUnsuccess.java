package com.tsc.selenium;

import java.util.concurrent.TimeUnit;

import org.hamcrest.CoreMatchers;
import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginUnsuccess {
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
    driver.get(baseUrl + "/mercurywelcome.php");
    driver.findElement(By.name("userName")).sendKeys("doquangkhai");
    driver.findElement(By.name("password")).sendKeys("123456");
    driver.findElement(By.name("login")).click();
    assertThat(driver.getCurrentUrl(), CoreMatchers.containsString("http://newtours.demoaut.com/mercurysignon.php"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
