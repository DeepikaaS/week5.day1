package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DuplicateLeadTestNG extends BaseClass{
	@Test
	public void duplicateLeadTest() throws InterruptedException {
		/*
		 * WebDriverManager.chromedriver().setup(); ChromeDriver driver = new
		 * ChromeDriver(); driver.get("http://leaftaps.com/opentaps/control/login");
		 * driver.manage().window().maximize();
		 * driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		 * driver.findElement(By.id("password")).sendKeys("crmsfa");
		 * driver.findElement(By.className("decorativeSubmit")).click();
		 * driver.findElement(By.xpath("//a[@style='color: black;']")).click();
		 * driver.findElement(By.xpath("//a[text()='Leads']")).click();
		 */
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("(//label[text()='Email Address:'])/following::input")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(2000);
		WebElement name = driver.findElement(By.xpath("(//td[contains(@class,'x-grid3-td-firstName')]/div/a)[2]"));

		String firstName = name.getText();
		System.out.println(firstName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[contains(@class,'x-grid3-td-firstName')]/div/a)[2]")).click();
//driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		String presentTitle = driver.getTitle();
		System.out.println(presentTitle);

		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		WebElement duplicateName = driver.findElement(By.id("viewLead_firstName_sp"));
		String dT = duplicateName.getText();
		System.out.println(dT);

		if (firstName.equals(dT)) {
			System.out.println("Titles are same");
			System.out.println("Closing browser");
		}
	}
}
