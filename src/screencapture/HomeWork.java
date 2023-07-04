package screencapture;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\new driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.get("http://127.0.0.1:5500/index.html");
		
		List<WebElement> myOptions = driver.findElements(By.tagName("option"));
		for (int i = 0; i < myOptions.size();i++) {
			if (i % 2 ==0) {
				myOptions.get(i).click();
				System.err.println("sorry I will remove "+myOptions.get(i).getText());
				driver.findElement(By.id("remove")).click();
			}
			else {
				System.out.println("I will keep"+myOptions.get(i).getText());
			}
		}
	}

}
