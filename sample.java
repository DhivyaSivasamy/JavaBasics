package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sample {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.nykaa.com/");
		driver.findElementByName("search-suggestions-nykaa").sendKeys("Perfumes", Keys.ENTER);
		List<WebElement> name = driver.findElementsByXPath("//div[@class='m-content__product-list__title']//span");
		List<String>product = new ArrayList<String>();
		for (WebElement n : name) {
			String pro = n.getText();
			product.add(pro);			
		}
		List<WebElement> price = driver.findElementsByXPath("//span[@class='post-card__content-price-offer']");
		List<String> value = new ArrayList<String>();
		for (WebElement p : price) {
			String pr = p.getText();
			value.add(pr);			
		}
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		WebElement shade = driver.findElementByXPath("//span[text()='PREVIEW SHADES']");
		executor.executeScript("arguments[0].click();", shade);
		
		WebElement add = driver.findElementByXPath("//button[text()='ADD TO BAG']");
		executor.executeScript("arguments[0].click();", add);
		
		driver.findElementById("SearchInputBox").sendKeys("Sunglasses", Keys.ENTER);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//button[text()='ADD TO BAG']"));
		executor.executeScript("arguments[0].click();", element);
		driver.findElementByClassName("BagItems").click();
		
		
		
		
		
		
		
		
		
		

	}

}
