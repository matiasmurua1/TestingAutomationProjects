package com.selenium.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.driver.DriverFactory;
import com.selenium.pages.AlojamientoDespegarPage;
import com.selenium.pages.InicioDespegarPage;
import com.selenium.pages.ResultadoBusquedaDespegarPage;

public class DespegarTest extends DriverFactory {
	
	WebDriver driver = null;
	
	@BeforeMethod (alwaysRun = true)
	
	public void abrir(ITestContext context) {
		
	String url = "https://www.despegar.com.ar/";
	String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
	
	String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
	
	driver = levantarBrowser (navegador,url);

	}
	

	
	
	  @Test(description = "Validar busqueda de alojamiento en la pagina Despegar")
	  public void PruebaDespegar() throws Exception {
		  	  
		  
		  
		  
		 
		  
		  InicioDespegarPage objetoInicio = new InicioDespegarPage(driver);
		  AlojamientoDespegarPage objetoAlojamiento= new AlojamientoDespegarPage(driver);
		  Assert.assertTrue(objetoInicio.botonAlojamientoEstaHabilitado(),"Boton de alojamiento no habilitado");
		  objetoAlojamiento = objetoInicio.botonAlojamientoClick();
		  objetoAlojamiento.ingresoDestinoEsVisible();
		  objetoAlojamiento.ingresoDestinoClick();
		  objetoAlojamiento.ingresoDeCiudad("Doha, Baladiyat ad Dawhah, Qatar");
		  objetoAlojamiento.fechaEntradaClick();
		  objetoAlojamiento.entendiCerrarClick();
		  objetoAlojamiento.ingresoDesdeClick();
		  objetoAlojamiento.fechaSalidaClick();
		  objetoAlojamiento.ingresoHastaClick();
		  objetoAlojamiento.seleccionClick();
		  objetoAlojamiento.sumarAdultosClick();
		  objetoAlojamiento.sumarMenoresClick();
		  objetoAlojamiento.seleccionarEdadMenorClick();
		  objetoAlojamiento.aplicarHabitacionesClick();
		  objetoAlojamiento.cerrarLoginClick();
		  
		  ResultadoBusquedaDespegarPage objetoResultado = new ResultadoBusquedaDespegarPage(driver);
		  objetoResultado = objetoAlojamiento.buscarAlojamientoClick();
		  objetoResultado.primerResultadoVisible();
		  System.out.println("Se realizo correctamente la busqueda");
		  
		  
		  
	  }
	  @AfterMethod
	  public void endSetup(){
	  driver.close();
	  }
	}