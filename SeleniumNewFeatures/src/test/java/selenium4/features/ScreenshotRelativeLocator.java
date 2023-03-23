package selenium4.features;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import base.Base;

public class ScreenshotRelativeLocator extends Base {
	
	@Test(priority = 0)
	public void launchWebsite() {
		driver.get("https://www.amazon.in");
	}
	
	@Test(priority = 1)
	public void takeScreenshot() throws IOException {
		
		WebElement element = driver.findElement(RelativeLocator.with(By.tagName("a")).toLeftOf(By.id("glow-ingress-block")));
		File src = element.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"/Screenshots/logo.png");
		FileUtils.copyFile(src, dest);
	}
	
}
