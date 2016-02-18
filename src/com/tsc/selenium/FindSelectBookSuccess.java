package com.tsc.selenium;

import java.util.concurrent.TimeUnit;

import org.hamcrest.CoreMatchers;
import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class FindSelectBookSuccess {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://newtours.demoaut.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testT() throws Exception {
		  
		//Login
	    driver.get(baseUrl + "/mercurywelcome.php");
	    driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys("123124");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("123123");
	    driver.findElement(By.name("login")).click();
	    
	    //Flight Finder
	    driver.findElement(By.name("tripType")).click();
	    new Select(driver.findElement(By.name("passCount"))).selectByVisibleText("2");
	    new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("Frankfurt");
	    new Select(driver.findElement(By.name("fromMonth"))).selectByVisibleText("March");
	    new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText("20");
	    new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("New York");
	    new Select(driver.findElement(By.name("toMonth"))).selectByVisibleText("April");
	    new Select(driver.findElement(By.name("toDay"))).selectByVisibleText("9");
	    driver.findElement(By.cssSelector("font > font > input[name=\"servClass\"]")).click();
	    new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Pangea Airlines");
	    driver.findElement(By.name("findFlights")).click();
	    
	    //Select Flight
	    driver.findElement(By.xpath("(//*[@name='outFlight'])[2]")).click();
	    driver.findElement(By.xpath("(//*[@name='inFlight'])[3]")).click();
	    driver.findElement(By.name("reserveFlights")).click();
	    
	    //Book A Flight
	    driver.findElement(By.name("passFirst0")).clear();
	    driver.findElement(By.name("passFirst0")).sendKeys("Quang Khai");
	    driver.findElement(By.name("passLast0")).clear();
	    driver.findElement(By.name("passLast0")).sendKeys("Do");
	    new Select(driver.findElement(By.name("pass.0.meal"))).selectByVisibleText("Low Calorie");
	    new Select(driver.findElement(By.name("pass.1.meal"))).selectByVisibleText("Low Cholesterol");
	    driver.findElement(By.name("passFirst1")).clear();
	    driver.findElement(By.name("passFirst1")).sendKeys("Gau cua Khai");
	    driver.findElement(By.name("passLast1")).clear();
	    driver.findElement(By.name("passLast1")).sendKeys("Nguyen");
	    driver.findElement(By.name("creditnumber")).clear();
	    driver.findElement(By.name("creditnumber")).sendKeys("1122334455");
	    new Select(driver.findElement(By.name("cc_exp_dt_mn"))).selectByVisibleText("04");
	    new Select(driver.findElement(By.name("cc_exp_dt_yr"))).selectByVisibleText("2009");
	    driver.findElement(By.name("cc_frst_name")).clear();
	    driver.findElement(By.name("cc_frst_name")).sendKeys("Quang Khai");
	    driver.findElement(By.name("cc_mid_name")).clear();
	    driver.findElement(By.name("cc_mid_name")).sendKeys("Quang");
	    driver.findElement(By.name("cc_frst_name")).clear();
	    driver.findElement(By.name("cc_frst_name")).sendKeys("Khai");
	    driver.findElement(By.name("cc_last_name")).clear();
	    driver.findElement(By.name("cc_last_name")).sendKeys("Do");
	    driver.findElement(By.name("ticketLess")).click();
	    driver.findElement(By.name("billAddress1")).clear();
	    driver.findElement(By.name("billAddress1")).sendKeys("Ha Noi");
	    driver.findElement(By.name("billAddress2")).clear();
	    driver.findElement(By.name("billAddress2")).sendKeys("Ha Noi");
	    driver.findElement(By.name("billCity")).clear();
	    driver.findElement(By.name("billCity")).sendKeys("Ha Noi");
	    driver.findElement(By.name("billState")).clear();
	    driver.findElement(By.name("billState")).sendKeys("Ha Noi");
	    driver.findElement(By.name("billZip")).clear();
	    driver.findElement(By.name("billZip")).sendKeys("Ha Noi");
	    new Select(driver.findElement(By.name("billCountry"))).selectByVisibleText("VIETNAM");
	    driver.findElement(By.xpath("(//*[@name='ticketLess'])[1]")).click();
	    driver.findElement(By.name("delAddress1")).clear();
	    driver.findElement(By.name("delAddress1")).sendKeys("Ha Noi");
	    driver.findElement(By.name("delAddress2")).clear();
	    driver.findElement(By.name("delAddress2")).sendKeys("Ha Noi");
	    driver.findElement(By.name("delCity")).clear();
	    driver.findElement(By.name("delCity")).sendKeys("Ha Noi");
	    driver.findElement(By.name("delState")).clear();
	    driver.findElement(By.name("delState")).sendKeys("Ha Noi");
	    driver.findElement(By.name("delZip")).clear();
	    driver.findElement(By.name("delZip")).sendKeys("Ha Noi");
	    new Select(driver.findElement(By.name("delCountry"))).selectByVisibleText("TOKELAU");
	    assertEquals("You have chosen a mailing location outside of the United States and its territories. An additional charge of $6.5 will be added as mailing charge.", closeAlertAndGetItsText());
	    driver.findElement(By.name("buyFlights")).click();
	    assertThat(driver.getCurrentUrl(), CoreMatchers.containsString("http://newtours.demoaut.com/mercurypurchase2.php"));
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}
