package selenium4.features;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.testng.annotations.Test;

import base.Base;

public class DevToolsLocation extends Base{
	
	static DevTools devTools;
	
	@Test
	public void changeLocation() {
		
		devTools = ((HasDevTools) driver).getDevTools();
		devTools.createSession();
		
		Map<String, Object> parameters = new HashMap<String, Object>();
	
			parameters.put("latitude", 61);
			parameters.put("longitude", 107);
			parameters.put("accuracy", 1);
		
			
	    //((ChromiumDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", parameters);
		 ((ChromiumDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", parameters);
	    
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("Netflix", Keys.ENTER);
        driver.findElement(By.cssSelector(".LC20lb")).click();
        
        String Msg = driver.findElement(By.xpath("//*[@class='default-ltr-cache-cvi30i e1yzhtxy7']")).getText();
        System.out.println(Msg);
	}
}
