package utils;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddExtention {

			public static void main(String[] args) throws InterruptedException {
				ChromeOptions options = new ChromeOptions();
				options.addExtensions(new File("./data/Tabs saver 2.5.4.0.crx"));
				
				WebDriverManager.chromedriver().setup();
				
				ChromeDriver driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				
		/*
		 * String URL = "chrome://extensions/?id=kmabfaomlcjlnplkoflgenkmmpilmead";
		 * 
		 * driver.get(URL);
		 */
				
				driver.navigate().to("http://leaftaps.com/opentaps/control/main");
				Thread.sleep(3000);
				driver.findElementById("username").sendKeys("DemoSalesManager");
				driver.findElementById("password").sendKeys("crmsfa");
				driver.findElementByClassName("decorativeSubmit").click();
			}

		

}
