import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		WebDriverWait dw = new WebDriverWait(driver, Duration.ofSeconds(5));
		String[] itesneeded = { "Brocolli", "Cucumber", "Beetroot" };
		addItem(driver, itesneeded);
		driver.findElement(By.xpath("//a[@class='cart-icon'] //img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block'] //button[text()='PROCEED TO CHECKOUT']")).click();
		//Thread.sleep(3000);
		dw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter promo code' and @class='promoCode']")));
		driver.findElement(By.xpath("//input[@placeholder='Enter promo code' and @class='promoCode'] "))
				.sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//div[@class='promoWrapper'] //button[text()='Apply']")).click();
		
		dw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Code applied ..!']")));
		System.out.println(driver.findElement(By.xpath("//span[text()='Code applied ..!']")).getText());

	}

	public static void addItem(WebDriver driver, String[] itesneeded) {
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));

		int count = 0;
		for (int i = 0; i < products.size(); i++) {
			// concerting array to List
			String[] name = products.get(i).getText().split("-");

			String FormatedName = name[0].trim();
			// System.out.println(FormatedName);
			List itemsNeededList = Arrays.asList(itesneeded);

			if (itemsNeededList.contains(FormatedName)) {
				count++;

				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				if (count == 3) {
					break;
				}

			}
		}

	}

}
