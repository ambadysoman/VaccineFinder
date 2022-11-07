package AbstractComponents;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractComponent {
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		
	}
	
By button=By.cssSelector("button.mr-2");
By slot=By.cssSelector(".list-group-item");
By slotButton=By.cssSelector(".justify-content-between");
By cardTitle=By.cssSelector(".card-title");
By cowinButton=By.linkText("Go To Cowin");
	public void waitForElementToAppear(By element) {
WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
wait.until(ExpectedConditions.visibilityOfElementLocated(element));
}
	
	public void waitForElementToClickable(By element) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void searchforButtonAndClick(String name) {
		
		List<WebElement> elements=driver.findElements(button);
		for(int i=0;i<elements.size();i++) {
			
			String buttonName=elements.get(i).getText();
			if(buttonName.equalsIgnoreCase(name)) {
				driver.findElements(button).get(i).click();
				break;
			}
		}
	}
	
public void searchforSlotAndClick(String name) {
		
		List<WebElement> elements=driver.findElements(slot);
		for(int i=0;i<elements.size();i++) {
			
			String buttonName=elements.get(i).getText();
			if(buttonName.contains(name)) {
				driver.findElements(slotButton).get(i).click();
				break;
			}
		}
	}

public boolean searchforhospital(String name) throws InterruptedException {
	boolean value = false;
	List<WebElement> elements=driver.findElements(cardTitle);
	for(int i=0;i<elements.size();i++) {
		
		String hospitalName=elements.get(i).getText();
		
		if(hospitalName.contains(name)) {
			value=true;
			break;
		}
		else 
			value=false;
		}	
	return value;
	}
	



public void searchforhospitalAndClickonCovin(String name) throws InterruptedException {
		
	List<WebElement> elements=driver.findElements(cardTitle);
	for(int i=0;i<elements.size();i++) {
		
		String hospitalName=elements.get(i).getText();
		
		if(hospitalName.contains(name)) {
			waitForElementToAppear(cowinButton);
			driver.findElements(cowinButton).get(i).click();
			break;
		}
			
	}
	

}
public void navigateToTab() {
	 
	ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(newTab.get(1));
	
	
	}
	


	}
