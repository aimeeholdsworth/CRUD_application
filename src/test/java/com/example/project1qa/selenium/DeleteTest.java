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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DeleteTest {
	
	@LocalServerPort
	private int port;
	
	private RemoteWebDriver driver;
	
	
	@BeforeEach
	void setup() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	
	}
	
	@Test
	void deleteTest() {
		
this.driver.get("http://localhost:" + port);
		
		WebDriverWait explicitWait = new WebDriverWait(driver, 5);
		
		WebElement locateDeleteButton = explicitWait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"output\"]/div/div/div[2]/button[1]")));
		
		locateDeleteButton.sendKeys(Keys.RETURN);
		
	}
	
	@AfterEach
	void tearDown() {
		this.driver.close();
	}	

}
