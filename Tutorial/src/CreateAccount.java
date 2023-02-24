import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record.ForDefinedMethod.WithAnnotationDefaultValue;

public class CreateAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wd = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.xpath("//a[text()='Register here']")).click();
		driver.findElement(By.id("firstName")).sendKeys("Trilochan");
		driver.findElement(By.id("lastName")).sendKeys("Kawadgave");
		driver.findElement(By.id("userEmail")).sendKeys("tKawadgave@gmail.com");
		driver.findElement(By.id("userMobile")).sendKeys("9665003538");
		WebElement occupation = driver.findElement(By.xpath("//select[@formcontrolname='occupation']"));
		Select occupationList = new Select(occupation);
		occupationList.selectByVisibleText("Student");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		driver.findElement(By.id("userPassword")).sendKeys("Tri@1234");
		driver.findElement(By.id("confirmPassword")).sendKeys("Tri@1234");
		driver.findElement(By.xpath("//input[@formcontrolname='required']")).click();
		driver.findElement(By.id("login")).click();
		Assert.assertEquals("Account Created Successfully", driver.findElement(By.xpath("//h1[text()='Account Created Successfully']")).getText());
				
	}

}
