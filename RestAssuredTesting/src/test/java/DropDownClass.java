
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownClass {
	
	@Test
	public void dropDownMethod() {
		
		
		System.setProperty("webdriver.chrome.driver", "/home/ameyo/Documents/driversExeFiles/chromedriver");
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://node55.ameyo.net:8443/app/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		//Login webelement
		WebElement username=driver.findElement(By.xpath("//input[@automationid='enterLoginUsername']"));     //username
		username.sendKeys("mona1");
		WebElement password= driver.findElement(By.xpath("//input[@automationid='enterLoginPassword']"));    //password
		password.sendKeys("mona1");
		WebElement loginbutton=driver.findElement(By.xpath("//*[@automationid='loginButton']"));
		loginbutton.click();
		
		//Nextpage Campaign selection
		
		//WebElement iccampaignselection=driver.findElement(By.xpath("//*[@id='select2-7wwy-container']"));
		//Select select=new Select(iccampaignselection);
		
		//select.selectByVisibleText("monika_ic");
		
		
		
		
		
		
		
	}

}
