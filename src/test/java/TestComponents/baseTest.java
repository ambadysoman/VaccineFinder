package TestComponents;






import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;



public class baseTest {

	public WebDriver driver;
	@BeforeTest
	public void initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\globalData.properties");
		prop.load(fis);
		String browserName= prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("websiteURL"));
		
		}
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();;
	}
	
}
