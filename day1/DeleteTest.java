package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteTest extends BaseClass{
  @Test
  public void DeleteLeadTestNG() throws InterruptedException {
		/*
		 * WebDriverManager.chromedriver().setup(); ChromeDriver driver=new
		 * ChromeDriver(); driver.get("http://leaftaps.com/opentaps/control/login");
		 * driver.manage().window().maximize();
		 * driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		 * driver.findElement(By.id("password")).sendKeys("crmsfa");
		 * driver.findElement(By.className("decorativeSubmit")).click();
		 * driver.findElement(By.xpath("//a[@style='color: black;']")).click();
		 * 
		 * driver.findElement(By.linkText("Leads")).click();
		 */
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.partialLinkText("Phone")).click();
		//WebElement code = driver.findElement(By.partialLinkText("phoneCountryCode"));
		WebElement code = driver.findElement(By.xpath("//input[@type='text' and @name='phoneCountryCode']"));
		code.clear();
		code.sendKeys("4");
		driver.findElement(By.name("phoneAreaCode")).sendKeys("210");
		driver.findElement(By.xpath("//input[@class=' x-form-text x-form-field' and @name='phoneNumber']")).sendKeys("8985846321");
		//driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		WebElement leadId = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		String IdNo = leadId.getText();
		System.out.println(IdNo);
		leadId.click();
		//(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a
		
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		//ask ram
		WebElement id = driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input"));
		//Thread.sleep(2000);
      id.sendKeys(IdNo);
      
      driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
      
      //WebElement text = driver.findElement(By.xpath("//div[@class='x-toolbar x-small-editor']//div"));
      //unable to locate
      Thread.sleep(2000);
      String deletionMsg = driver.findElement(By.xpath("(//div[@class='x-paging-info' and text()='No records to display'])")).getText();
		
		System.out.println(deletionMsg);
		if (deletionMsg.equals("No records to display")) {
			System.out.println("successfully deleted the lead");
  }
}
}
