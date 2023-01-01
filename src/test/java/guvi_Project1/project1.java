package guvi_Project1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class project1 {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String n, String s) {
		driver.findElement(By.name("username")).sendKeys(n);
		driver.findElement(By.name("password")).sendKeys(s);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"))
						.isEnabled());
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		driver.findElement(By.name("firstName")).sendKeys("siva");
		driver.findElement(By.name("middleName")).sendKeys("Kumar");
		driver.findElement(By.name("lastName")).sendKeys("V");
		driver.findElement(By.xpath("//label[text()='Employee Id']//following::input[1]")).clear();
		driver.findElement(By.xpath("//label[text()='Employee Id']//following::input[1]")).sendKeys("0501");
		driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
		driver.findElement(By.xpath("//div//input[@class='oxd-input oxd-input--active']//following::input[7]")).sendKeys("Siva kumar");
		driver.findElement(By.xpath("//div//input[@class='oxd-input oxd-input--active']//following::input[10]")).sendKeys("Siva2001#");
		driver.findElement(By.xpath("//div//input[@class='oxd-input oxd-input--active']//following::input[11]")).sendKeys("Siva2001#");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div[2]/div/div/div[2]/input")).sendKeys("Kumar");
		driver.findElement(By.xpath("(//div[@class='oxd-grid-3 orangehrm-full-width-grid']//input)[3]")).sendKeys("15151");
        driver.findElement(By.xpath("(//*[starts-with(text(),'Driver')]//following::input)[1]")).sendKeys("7305776724");
        driver.findElement(By.xpath("(//*[starts-with(text(),'License Expiry Date')]//following::input)[1]")).sendKeys("2022-12-22");
	    driver.findElement(By.xpath("(//*[starts-with(text(),'SSN Number')]//following::input)[1]")).sendKeys("8652431293");
	    driver.findElement(By.xpath("(//*[starts-with(text(),'SIN Number')]//following::input)[1]")).sendKeys("67534");
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement nationality = driver.findElement(By.xpath("(//*[text()='-- Select --']//following::div)[1]"));
		Actions act = new Actions(driver);
		act.sendKeys(nationality , "I").sendKeys(Keys.ARROW_DOWN, Keys.RETURN).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).sendKeys(Keys.ENTER, Keys.RETURN).build().perform();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    WebElement marriedStatus = driver.findElement(By.xpath("(//*[text()='Marital Status']//following::i)[1]"));
		Actions ac = new Actions(driver);
		ac.sendKeys(marriedStatus , "S").sendKeys(Keys.ARROW_DOWN, Keys.RETURN).sendKeys(Keys.ENTER).build().perform();
	    driver.findElement(By.xpath("(//*[starts-with(text(),'Date of Birth')]//following::input)[1]")).sendKeys("2001-05-05");
		driver.findElement(By.xpath("(//*[starts-with(text(),'Gender')]//following::span)[1]")).click();
		driver.findElement(By.xpath("(//*[starts-with(text(),'Military Service')]//following::input)[1]")).sendKeys("NO");
		driver.findElement(By.xpath("(//*[starts-with(text(),'Smoker')]//following::span)[1]")).click();
		driver.findElement(By.xpath("(//*[text()=' * Required']//following::button)[1]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 WebElement BloodType = driver.findElement(By.xpath("(//*[starts-with(text(),'Blood Type')]//following::div)[1]"));
			Actions group = new Actions(driver);
			group.sendKeys(BloodType , "A+").sendKeys(Keys.ARROW_DOWN, Keys.RETURN).sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("(//div[@class='oxd-form-actions']//following::button)[2]")).click();
		System.out.println("Congratulation Successfully Completed");
		
		

		
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver= new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 
  }

  @AfterMethod
  public void afterMethod() {
	 // driver.close();
  }


  @DataProvider(name="dp")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
    };
  }
}
