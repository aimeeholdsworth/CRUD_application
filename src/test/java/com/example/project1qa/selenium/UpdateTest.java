package com.example.project1qa.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UpdateTest {
	@LocalServerPort
	private int port;
	
	private RemoteWebDriver driver;
	
	@BeforeEach
	void setup() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	
	}
	
	@Test
	void updateTest() {
		this.driver.get("http://localhost:" + port);
		
		// tell the test to wait so that the card can definitely have loaded
		WebDriverWait explicitWait = new WebDriverWait(driver, 10);
		
		WebElement locateUpdate = explicitWait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"output\"]/div/div/div[2]/button[2]")));
		
		locateUpdate.sendKeys(Keys.RETURN);
		
		WebElement enterArtist = this.driver.findElementById("newArtist");
		
		enterArtist.sendKeys("1975");
		
		WebElement enterCity = this.driver.findElementById("newCity");
		
		enterCity.sendKeys("Bristol");
		
		WebElement enterVenue = this.driver.findElementById("newVenue");
		
		enterVenue.sendKeys("O2");
		
		WebElement enterDate = this.driver.findElementById("newGigDate");
		
		enterDate.sendKeys("09092021");
		
		WebElement enterTime = this.driver.findElementById("newGigTime");
		
		enterTime.sendKeys("7");
		
		WebElement submitButton = this.driver.findElement(By.cssSelector("#updateForm > button:nth-child(12)"));
		submitButton.click(); 
		
		WebElement closeButton = this.driver.findElement(By.cssSelector("#myModal > div > div > div.modal-footer > button"));
		
		closeButton.click();
	}
	
	@AfterEach
	void tearDown() {
		this.driver.close();
	}	

}
