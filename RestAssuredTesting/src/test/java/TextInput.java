import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextInput {
	
@Test

public void enterTextUsingJavaScript() throws Exception {
	

	System.setProperty("webdriver.chrome.driver","/home/ameyo/Documents/driversExeFiles/chromedriver");
	
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://node55.ameyo.net:8443/app/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	WebElement element=driver.findElement(By.xpath("//*[@automationid='enterLoginUsername']"));
	element.sendKeys("Administrator");
	
	WebElement element1=driver.findElement(By.xpath("//*[@automationid='enterLoginPassword']"));
	element1.sendKeys("Administrator");
	
	WebElement element2=driver.findElement(By.xpath("//*[@automationid='loginButton']"));
	element2.click();
	
	
	
	String title=driver.getTitle();
	System.out.println("title of the page" +title);
	Assert.assertEquals(title, "Ameyo");
	
	
	
	
	//Verify logouttime is null or not in db 
	
	
    
	//Alert if logout_time is null in db
	//Alert alert=driver.switchTo().alert();
    //alert.accept();
	
    
    
	//Screenshottaken
	Date d = new Date();
    System.out.println(d.toString());

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile, new File("/home/ameyo/Downloads/image/"+sdf.format(d)+".png"));
	
	
	//javasc
	//String javascript = "document.evaluate('//input[automationid='enterLoginUsername']').singleNodeValue[mona1])";  
	//JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
	//WebElement element2 = (WebElement) jsExecutor.executeScript(javascript);
	
	
	
	driver.close();
	}

}
