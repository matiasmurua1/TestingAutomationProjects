package com.selenium.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlojamientoDespegarPage {
	
	@FindBy(xpath="//*[@class='input-container']//*[@placeholder='Ingresá una ciudad, alojamiento o punto de interés']")
	WebElement ingresoDestino;
	
	@FindBy(xpath="//*[@class='input-container']//*[@placeholder='Entrada']")
	WebElement fechaEntrada;
	
	@FindBy(xpath="//*[@class='lgpd-banner--button eva-3-btn -white -md']")
	WebElement entendiCerrar;
	
	@FindBy(xpath="//*[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//*[@class='sbox5-monthgrid-dates sbox5-monthgrid-dates-30']\r\n"
			+ "//*[@class='sbox5-monthgrid-datenumber-number'][text()='23']")
	WebElement ingresoDesde;
	
	@FindBy(xpath="//*[@class='input-container']//*[@placeholder='Salida']")
	WebElement fechaSalida;
	
	@FindBy(xpath="//*[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//*[@class='sbox5-monthgrid-dates sbox5-monthgrid-dates-31']//*[@class='sbox5-monthgrid-datenumber-number'][text()='15']")
	WebElement ingresoHasta;
	
	@FindBy(xpath="//*[@class='sbox5-3-bed-svg']")
	WebElement seleccion;
	
	@FindBy(xpath="//*[@class='stepper__distribution_container']//*[@class='steppers-icon-right stepper__icon']")
	List <WebElement> listaSumarAdultos;
	
	@FindBy(xpath="//*[@class='stepper__distribution_container']//*[@class='steppers-icon-right stepper__icon']")
	List <WebElement> listaSumarMenores;
	
	@FindBy(xpath="//*[@class='select-container']//*[@class='select-option'][text()='10 años']")
	WebElement edadMenor;
	
	@FindBy(xpath="//*[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//*[@class='stepper__room__footer ']//*[@class='sbox5-3-btn -md -primary']//*[@class='btn-text']")
	WebElement aplicarHabitaciones;
	
	@FindBy(xpath="//*[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']")
	WebElement buscarAlojamiento;
	
	@FindBy(xpath="//*[@class='login-incentive--close shifu-3-icon-close -eva-3-mr-md']")
	WebElement cerrarLogin;
	
	
	private WebDriver driver = null;

	WebDriverWait wait;
	
	public AlojamientoDespegarPage (WebDriver driver) {
		
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
		
		
	}
	
	public boolean ingresoDestinoEsVisible() {
		return this.ingresoDestino.isDisplayed();
	}
	
	public void ingresoDestinoClick() {
		
		this.ingresoDestino.click();
		
		
	}
	
	public void ingresoDeCiudad(String texto) throws InterruptedException {
		this.ingresoDestino.sendKeys(texto);
		Thread.sleep(2000);
		this.ingresoDestino.sendKeys(Keys.CONTROL);
		
		//wait.until(ExpectedConditions.visibilityOf(this.ingresoDestino));
		Thread.sleep(2000);
		this.ingresoDestino.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		
	}
	
	public void fechaEntradaClick() {
		
		this.fechaEntrada.click();
		
		}
	
	public void entendiCerrarClick() {
		
		this.entendiCerrar.click();
		
		}
	
	public void ingresoDesdeClick() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(this.ingresoDesde));
		this.ingresoDesde.click();
	}
	
	public void fechaSalidaClick() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(this.fechaSalida));
		this.fechaSalida.click();
	}
	
	public void ingresoHastaClick() throws InterruptedException {
		//Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(this.ingresoHasta));
		
		this.ingresoHasta.click();
	}
	
	public void seleccionClick()   {
		
		this.seleccion.click();
		
	}
	
	public void sumarAdultosClick()throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(this.listaSumarAdultos.get(2)));
		this.listaSumarAdultos.get(2).click();
	}
	
	public void sumarMenoresClick() {
		this.listaSumarMenores.get(3).click();
	}
	
	public void seleccionarEdadMenorClick() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(this.edadMenor));
		this.edadMenor.click();
	}
	
	public void aplicarHabitacionesClick() throws InterruptedException {
		this.aplicarHabitaciones.click();
		
	}
	public void cerrarLoginClick() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(this.cerrarLogin));
		this.cerrarLogin.click();
		
	}
	
	public ResultadoBusquedaDespegarPage buscarAlojamientoClick() {
		this.buscarAlojamiento.click();
		return new ResultadoBusquedaDespegarPage (this.driver);
	}
	
}
