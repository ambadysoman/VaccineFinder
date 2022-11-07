package TestCase;




import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;


import org.testng.annotations.Test;


import TestComponents.baseTest;
import pageobjects.Cowin;
import pageobjects.VaccineFinderHome;

public class TestCase extends baseTest{

	@Test
	public void TC001_happyPath() throws InterruptedException, IOException  {
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\globalData.properties");
		prop.load(fis);
		VaccineFinderHome homeobj= new VaccineFinderHome(driver);
		Cowin cowinObj=new Cowin(driver);
		homeobj.stateDropDownSelection(prop.getProperty("state"));
		homeobj.districtDropDownSelection(prop.getProperty("district"));
		homeobj.vaccineButtonClick(prop.getProperty("vaccine"));
		homeobj.typeButtonClick(prop.getProperty("type"));
		homeobj.ageButtonClick(prop.getProperty("age"));
		homeobj.doseButtonClick(prop.getProperty("dose"));
		homeobj.slotButtonClick(prop.getProperty("day"));
		boolean isNoCentersFoundCardPresent=homeobj.isNoCentersFoundCardPresent();
		assertEquals(isNoCentersFoundCardPresent, false, "No Centers Found with Selected Filters");
		boolean isHospitalPresent=homeobj.isHospitalPresent(prop.getProperty("hospital"));
		assertEquals(isHospitalPresent, true, "No hospital with the name found");
		homeobj.searchforhospitalAndClickonCovin(prop.getProperty("hospital"));
		boolean isRegisterTextPresent=cowinObj.isRegisterTextPresent();
		assertEquals(isRegisterTextPresent, true, "Cowin page not found");
		
	}
	
}
