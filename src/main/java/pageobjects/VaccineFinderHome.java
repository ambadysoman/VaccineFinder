package pageobjects;


import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import AbstractComponents.AbstractComponent;


public class VaccineFinderHome extends AbstractComponent {

	WebDriver driver;
	@FindBy (name = "selectState")
	WebElement selectStateDropdown;
	@FindBy (name="selectedDistrict")
	WebElement selectDistrictDropdown;
	@FindBy (css=".card-title")
	WebElement cardTitle;
	
	
	By logo=By.cssSelector(".navbar-brand");
	By resetButton=By.xpath("//button[@title='Reset Current Search']");
	
	
	public VaccineFinderHome(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

public void stateDropDownSelection(String state) throws InterruptedException, IOException {
	
	waitForElementToAppear(logo);
	waitForElementToClickable(resetButton);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	Select stateDropdown= new Select(selectStateDropdown);
	stateDropdown.selectByVisibleText(state);
}
public void districtDropDownSelection(String district) throws InterruptedException, IOException {
	
	waitForElementToAppear(logo);
	Select DistrictDropdown= new Select(selectDistrictDropdown);
			DistrictDropdown.selectByVisibleText(district);
}
public void vaccineButtonClick(String vaccineName) {
	searchforButtonAndClick(vaccineName);
}
public void typeButtonClick(String type) {

	searchforButtonAndClick(type);
}
public void ageButtonClick(String age) {	
	searchforButtonAndClick(age);
}
public void doseButtonClick(String dose) {	
	searchforButtonAndClick(dose);
	
}
public void slotButtonClick(String day) {	
	searchforSlotAndClick(day);
	
}

public String getCardTitle() {
	String title=cardTitle.getText();
	return title;
}

public boolean isNoCentersFoundCardPresent() {
	boolean value=false;
	if(cardTitle.getText().equalsIgnoreCase("No Centers Found")) {					 
		value=true;
	}
	
	return value;
 }  

public boolean isHospitalPresent(String hospital) throws InterruptedException {
	Boolean isPresent=searchforhospital(hospital);
	return isPresent;
}


}