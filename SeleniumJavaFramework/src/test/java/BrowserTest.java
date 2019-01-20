

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BrowserTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hp\\Desktop\\Deepika\\SeleniumProject\\SeleniumJavaFramework\\drivers\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// Open the Facebook Login Page

		driver.get("https://en-gb.facebook.com/");

		// Find and enter Username

		WebElement un = driver.findElement(By.name("email"));

		un.sendKeys("abcd@gmail.com");

		// Find and enter password

		WebElement paswd = driver.findElement(By.id("pass"));

		paswd.sendKeys("abcd");

		// Create a new account on the Facebook

		WebElement firstName = driver.findElement(By.name("firstname"));

		firstName.sendKeys("Deepak");

		WebElement lastName = driver.findElement(By.name("lastname"));

		lastName.sendKeys("Singh");

		WebElement mobileNumber = driver.findElement(By.name("reg_email__"));

		mobileNumber.sendKeys("7425647327");

		WebElement passwd = driver.findElement(By.name("reg_passwd__"));

		passwd.sendKeys("Satyendra246");

		// Select the birth date

		Select birthDate = new Select(driver.findElement(By.name("birthday_day")));
		birthDate.selectByVisibleText("7");

		Select birthMonth = new Select(driver.findElement(By.name("birthday_month")));
		birthMonth.selectByVisibleText("Feb");

		Select birthYear = new Select(driver.findElement(By.name("birthday_year")));
		birthYear.selectByVisibleText("1995");

		WebElement sex = driver.findElement(By.xpath("//input[@id='u_0_a']"));
		sex.click();

		//WebElement signUp = driver.findElement(By.name("websubmit"));

		// signUp.click();

		/*
		 * WebElement btn = driver.findElement(By.id("loginbutton"));
		 * 
		 * btn.click();
		 * 
		 * WebElement recovery = driver.findElement(By.linkText("Forgotten password?"));
		 * 
		 * String rec = recovery.getText();
		 */

		driver.close();

	}

}
