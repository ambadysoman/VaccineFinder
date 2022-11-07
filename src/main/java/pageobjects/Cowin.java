package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class Cowin extends AbstractComponent{
	WebDriver driver;
	
	@FindBy (xpath = "//h2[text()='Register or Sign In for Vaccination']")
	WebElement registerText;
	public Cowin(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public Boolean isRegisterTextPresent() {
		navigateToTab();
		Boolean isTextPresent=registerText.isDisplayed();
		return isTextPresent;
	}
}
