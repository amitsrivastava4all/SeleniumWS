import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestWebSite {

	public static void main(String[] args) throws InterruptedException {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				rb.getString("driverpath"));
		WebDriver driver = new  ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.focus();");
		driver.manage().window().maximize();
		driver.get(rb.getString("url"));
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys(rb.getString("userid"));
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys(rb.getString("password"));
		WebElement loginBt = driver.findElement(By.id("u_0_l"));
		loginBt.click();
		//WebElement logout = driver.findElement(By.id("userNavigationLabel"));
		//logout.click();
		js.executeScript("document.getElementById('userNavigationLabel').click()");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement doLogout = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.className("_54nh")));
		
		//List<WebElement> links = driver.findElements(By.className("_54nh"));
		//System.out.println("Links Length "+links.size());
		js.executeScript("document.getElementById('show_me_how_logout_1').submit()");
		//WebElement doLogout = driver.findElement(By.id("show_me_how_logout_1"));
		//doLogout.click();
		
		System.out.println("After URL");
		//Thread.sleep(5000);
		//driver.close();
		

	}

}
