package com.mycompany.app.appEribank.pageObjects;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;


public class EribankPageObject extends PageObject{

	public DesiredCapabilities dc = new DesiredCapabilities();
	public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    
    
    ///////inicio
    String txt_usuario = "com.experitest.ExperiBank:id/usernameTextField";
    String txt_contrasena = "com.experitest.ExperiBank:id/passwordTextField";
    String btn_login = "com.experitest.ExperiBank:id/loginButton";
    String btn_ok="android:id/button1";
    String titulo_error = "android:id/alertTitle";
    //String mensaje_error = "android:id/message";
    String mensaje_error ="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.TextView";

    
    /////payment
    String btn_make = "com.experitest.ExperiBank:id/makePaymentButton";
    String input_phone ="com.experitest.ExperiBank:id/phoneTextField";
    String input_name ="com.experitest.ExperiBank:id/nameTextField";
    String input_amount ="com.experitest.ExperiBank:id/amountTextField";
    String btn_payment ="com.experitest.ExperiBank:id/sendPaymentButton";
    
	public void iniciarApp() throws MalformedURLException {
		dc.setCapability("deviceName", "Redmi");
        dc.setCapability("udid", "5b7ca85b7d2c");
        dc.setCapability("automationName", "uiautomator2");
        dc.setCapability("platformName", "Android");
        dc.setCapability("platformVersion", "9.0");
        dc.setCapability("app", "C:\\Users\\1813485\\Downloads\\ExperiBank.apk");
        dc.setCapability("skipUnlock","true");
        dc.setCapability("appPackage", "com.experitest.ExperiBank");
        dc.setCapability("appActivity","com.experitest.ExperiBank.LoginActivity");
        dc.setCapability("noReset","false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
        wait = new WebDriverWait(driver, 10);	
        
        driver.findElement(By.id(btn_ok)).click();
	}
	
	public void ingresarDatos(String usuario, String contrasena) {
		driver.findElement(By.id(txt_usuario)).sendKeys(usuario);
		driver.findElement(By.id(txt_contrasena)).sendKeys(contrasena);
		driver.findElement(By.id(btn_login)).click();
	}
	
	public void validarError() {
				
		Assert.assertEquals("Invalid username or password!", driver.findElement(By.xpath(mensaje_error)).getText());
	}
	
	public void llenarFormulario(String phone, String name, String amount) {
		wait(2);
		driver.findElement(By.id(btn_make)).click();
		driver.findElement(By.id(input_phone)).sendKeys(phone);
		driver.findElement(By.id(input_name)).sendKeys(name);
		driver.findElement(By.id(input_amount)).sendKeys(amount);
		
	}
	
	public void validarBotonPayment () {
		Assert.assertEquals(false, driver.findElement(By.id(input_amount)).getAttribute("clickable"));
	}
	
	private void wait(int t) {
		try {
			Thread.sleep(t*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    
    
}