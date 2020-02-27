package Package1;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class E2E_Script2 {
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mark\\Desktop\\chrome\\chromedriver_win32\\chromedriver.exe");		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\Users\\Mark\\Desktop\\Extensions\\ljngjbnaijcbncmcnjfhigebomdlkcjo\\5.1.0_0.crx"));
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		
		String Origin = "Bengaluru";
		String Destination = "Hyderabad";
		int daysahead = 3;
		int Discount = 1;    //  Family and Friend =1   ,  Senior Citizen =2 , Armed Forces=3 , Student=4, Unaccompanied=5    
	
		
		
		@SuppressWarnings("deprecation")
		WebDriver driver =new ChromeDriver(caps);

		driver.get("http://spicejet.com"); //URL in the browser
		
		driver.manage().window().maximize();
		
		// CLICK ON ORIGIN AND SELECT AN ORIGIN
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
	//	driver.findElement(By.xpath("//a[contains(text(),'Kandla (IXY)')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+Origin+"')]")).click();
		
		
		
		Thread.sleep(2000);

		
		// CLICK A DESTINATION AND SELECT A DESTINATION
		driver.findElement(By.cssSelector("div[id='glsctl00_mainContent_ddl_destinationStation1_CTNR']")).click();
	//	driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[contains(text(),'Hyderabad (HYD)')]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[contains(text(),'"+Destination+"')]")).click();
		
		
		Thread.sleep(3000);
		
		//SELECT A DAY IN CALENDAR
		//driver.findElement(By.cssSelector("a.ui-state-default ui-state-highlight")).click();
		//driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();
		
    	driver.findElement(By.xpath("//a[contains(@class,'ui-state-default')][contains(text(),'27')]")).click();
		

    	if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))

    		{

    		System.out.println("Calendar 2 its disabled"); 
    		

    		}
    	else
    		{
    		System.out.println("Calendar 2 its enable and hence it needs to be selected"); 
    		}
		
    	//SELECT ONE CHECKBOX.
    	
    	boolean checkbox = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected();
    	
		
		if (checkbox = true)
		{
		//	driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily'][contains(text(),'Family and Friends')]")).click();
	   //   driver.findElement(By.xpath("//input[contains(@type,'checkbox')][contains(@id,'friendsandfamily')]")).click();
			
			
			if (Discount==1)
			{
			 String DiscountF ="friendsandfamily";
			 driver.findElement(By.xpath("//input[contains(@type,'checkbox')][contains(@id,'"+DiscountF+"')]")).click();
			}
			
				else 
				{
				if(Discount==2)
					{
					String DiscountF ="SeniorCitizenDiscount";
					driver.findElement(By.xpath("//input[contains(@type,'checkbox')][contains(@id,'"+DiscountF+"')]")).click();
					}
					else
					{
					  if(Discount==3)
					  {
				    String DiscountF ="IndArm";	  
				    driver.findElement(By.xpath("//input[contains(@type,'checkbox')][contains(@id,'"+DiscountF+"')]")).click();
					  }
					}
				}
				
			System.out.println("Checkbox was not selected but now is Selected");
		}

      // SELECT NUMBER OF ADULTS
		
		







	}

}
