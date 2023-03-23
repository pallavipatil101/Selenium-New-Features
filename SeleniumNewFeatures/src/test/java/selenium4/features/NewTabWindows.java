package selenium4.features;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import base.Base;

public class NewTabWindows extends Base{

	@Test(priority = 0)
	public void launchWebsite() {
		driver.get("https://www.amazon.in");
	}
	
	@Test(priority =1)
	public void newTab() {
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		
	}
	
	@Test(priority = 2)
	public void newWindow() {		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.flipkart.com/");
		System.out.println(driver.getTitle());
	}
}
