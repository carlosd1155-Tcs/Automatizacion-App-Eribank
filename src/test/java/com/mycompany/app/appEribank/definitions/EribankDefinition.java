package com.mycompany.app.appEribank.definitions;

import java.net.MalformedURLException;

import com.mycompany.app.appEribank.steps.EribankSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class EribankDefinition {
	
	@Steps
	EribankSteps objStep;
	
	@Given("^Ingreso a la aplicacion$")
	public void ingreso_a_la_aplicacion() throws MalformedURLException {
	  objStep.iniciarApp();
	}

	@When("^ingreso usuario \"([^\"]*)\" y contrasena \"([^\"]*)\"$")
	public void ingreso_usuario_y_contrasena(String usuario, String contrasena) {
		objStep.ingresoDatos(usuario, contrasena);
	}

	@Then("^valido mensaje de error$")
	public void valido_mensaje_de_error() {
		objStep.validarError();
	}
	
	@When("^ingreso usuario y contrasena \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingreso_usuario_y_contrasena2(String usuario, String contrasena) {
	   objStep.ingresoDatos(usuario, contrasena);
	}


	@When("^seleccionar y llenar datos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void seleccionar_y_llenar_datos(String phone, String name, String amount) {
		objStep.llenarFormulario(phone, name, amount);
	}

	@Then("^valido estado boton$")
	public void valido_estado_boton() {

	}

	

}
