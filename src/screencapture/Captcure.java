package screencapture;

import static org.testng.AssertJUnit.assertEquals;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;
import io.opentelemetry.sdk.metrics.data.Data;

public class Captcure {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","D:\\new driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.get("http://127.0.0.1:5500/index.html");
		
		Date currentDate = new Date(0);//هاي المفروض ما تكون فيها صفر بس المحترم عنتر وطلب تكون (void)
		String TheAcutalDate = currentDate.toString().replace(":", "-");
		TakesScreenshot src = ((TakesScreenshot)driver);//اول اشي اسمو att
		File SrcFile = src.getScreenshotAs((OutputType.FILE));
		//File Dest = new File("C://mycapture/image.png");// هيك بعمل سكرين بس لما تتخزن بسير over ride
		//File Dest = new File("C://mycapture/"+TheAcutalDate+".png");
		File Dest = new File(".//mycapture/"+TheAcutalDate+".png");// هيك بخزن جوا الملف الي أنا فيه بدل ما يخزن بمكان تاني 
		FileUtils.copyFile(SrcFile, Dest);
		
		/*  TEST CASE => remove the items    */
		List<WebElement> thestudents =driver.findElements(By.tagName("option")); 
		int theTotalNumOfStudent = thestudents.size();
		System.out.println(theTotalNumOfStudent+"This is the total number of student");
		int HowManyItems = 5 ; // بغير العدد بناءا على التيست كيس
		for (int i = 0; i< HowManyItems; i++)  //theStudents.size() هيك لما بدي أحذفهم كلياتهم
		{
			driver.findElement(By.xpath(TheAcutalDate)).click();
		}
		List<WebElement> theStuentsAfterRemove = driver.findElements((By.tagName("option")));
		int actualNum = theStuentsAfterRemove.size();
		String s=Integer.toString(actualNum);
		System.out.println(actualNum+"This is the actual number of student");
		int expectedNum = theTotalNumOfStudent-HowManyItems;
		String x=Integer.toString(expectedNum);
		System.out.println(expectedNum+" This is the expected number of student");
		Assert.assertEquals(s,x);



	}

}
