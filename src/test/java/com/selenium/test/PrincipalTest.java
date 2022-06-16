package com.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.selenium.driver.DriverFactory;
import com.selenium.pages.WikiHomePage;
import com.selenium.pages.WikiResultsPage;

public class PrincipalTest extends DriverFactory  {
	
	@Test(description = "Validar que las busquedas en Wikipedia funcionan")
	public void validarBusquedaWikipedia()throws Exception{
		WebDriver driver = DriverFactory.levantarBrowser("CHROME", "https://es.wikipedia.org/wiki/Wikipedia:Portada");
		//el driver que le paso al wiki home es el de la linea 16 que lo trae el metodo levantarBrowser
		WikiHomePage wikihome = new WikiHomePage(driver);
		Assert.assertTrue(wikihome.searchInputEsVisible(), "No es visible");
		
		WikiResultsPage resultado = wikihome.searchText("Selenium");
		Assert.assertTrue(resultado.tituloEsVisible(), "No es visible");
		
		System.out.println("Caso de prueba exitoso");
		
		driver.close();
	}
	

	

}
