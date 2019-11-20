package com.mycompany.app.appEribank.steps;


import java.net.MalformedURLException;

import com.mycompany.app.appEribank.pageObjects.EribankPageObject;

import net.thucydides.core.annotations.Step;

public class EribankSteps {
	
	EribankPageObject objPage;
	
	@Step
	public void iniciarApp() throws MalformedURLException {
		objPage.iniciarApp();
	}
	
	@Step
	public void ingresoDatos(String usuario, String contrasena) {
		objPage.ingresarDatos(usuario, contrasena);
	}
	
	@Step
	public void validarError() {
		objPage.validarError();
	}
	
	@Step
	public void llenarFormulario(String phone, String name, String amount) {
		objPage.llenarFormulario(phone, name, amount);
	}
	
	 

}
