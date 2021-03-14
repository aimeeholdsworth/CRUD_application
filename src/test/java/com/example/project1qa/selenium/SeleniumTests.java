package com.example.project1qa.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SeleniumTests {
	
	@LocalServerPort
	private int port;
	
	private RemoteWebDriver driver;
	
	@BeforeEach
	void setup() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	
	}
	
	@Test
	void test() {
		this.driver.get("http://localhost:" + port);
		
		WebElement explore = this.driver.findElement(By.xpath("//*[@id=\"hero\"]/div/a/button"));
		
		explore.click();
		
		WebElement enterArtist = this.driver.findElementById("artist");
		
		enterArtist.sendKeys("1975");
		
		WebElement enterCity = this.driver.findElementById("city");
		
		enterCity.sendKeys("Bristol");
		
		WebElement enterVenue = this.driver.findElementById("venue");
		
		enterVenue.sendKeys("O2");
		
		WebElement enterDate = this.driver.findElementById("gigDate");
		
		enterDate.sendKeys("09092021");
		
		WebElement enterTime = this.driver.findElementById("gigTime");
		
		enterTime.sendKeys("7");
		
		WebElement submitButton = this.driver.findElement(By.cssSelector("#gigEntryForm > button:nth-child(12)"));
		submitButton.click();
		
	}
	
	@AfterEach
	void tearDown() {
		this.driver.close();
	}

}
