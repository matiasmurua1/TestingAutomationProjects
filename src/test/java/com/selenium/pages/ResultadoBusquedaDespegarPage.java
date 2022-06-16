package com.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultadoBusquedaDespegarPage {
	
	
	
	@FindBy(xpath="//*[@class='eva-3-icon-star']")
	WebElement primerResultado;
	
	
	private WebDriver driver=null;
	WebDriverWait wait;
	
	public ResultadoBusquedaDespegarPage (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean primerResultadoVisible() throws InterruptedException {
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(this.primerResultado));
		return this.primerResultado.isDisplayed();
	}

}
