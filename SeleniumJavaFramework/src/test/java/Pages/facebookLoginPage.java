package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class facebookLoginPage {

	WebDriver driver = null;

	By firstName_textBox = By.name("firstname");

	By lastName_textBox = By.name("lastname");

	By phoneNumber_textBox = By.name("reg_email__");

	By passwd_textBox = By.name("reg_passwd__");

	By sex = By.xpath("//input[@id='u_0_a']");

	public facebookLoginPage(WebDriver driver) {

		this.driver = driver;

	}


	public void enterFirstName(String fn) {

		driver.findElement(firstName_textBox).sendKeys(fn);
	}

	public void enterLastName(String ln) {

		driver.findElement(lastName_textBox).sendKeys(ln);

	}

	public void enterPhoneNumber(String phn) {

		driver.findElement(phoneNumber_textBox).sendKeys(phn);

	}

	public void enterPassword(String pswd) {

		driver.findElement(passwd_textBox).sendKeys(pswd);

	}
	
	public  void dateDropDown(int index) {
	      Select drop = new Select(driver.findElement(By.name("birthday_day")));
	      drop.selectByIndex(index);  
	}
	
	public  void monthDropDown(int index) {
	      Select drop = new Select(driver.findElement(By.name("birthday_month")));
	      drop.selectByIndex(index);  
	}
	
	public  void yearDropDown(int index) {
	      Select drop = new Select(driver.findElement(By.name("birthday_year")));
	      drop.selectByIndex(index);  
	}

	
	public void sex() {

		driver.findElement(sex).click();

	}

}
