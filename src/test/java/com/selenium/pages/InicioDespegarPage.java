package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InicioDespegarPage {
	
	@FindBy(xpath="//*[@class='shifu-icon-product shifu-3-icon-hotels']")
	WebElement botonAlojamiento;
	
	private WebDriver driver = null;
	
	public InicioDespegarPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean botonAlojamientoEstaHabilitado() {
		return this.botonAlojamiento.isEnabled();
	}
	
	public AlojamientoDespegarPage botonAlojamientoClick() {
		this.botonAlojamiento.click();
		return new AlojamientoDespegarPage (this.driver);
		
	}
	
}
