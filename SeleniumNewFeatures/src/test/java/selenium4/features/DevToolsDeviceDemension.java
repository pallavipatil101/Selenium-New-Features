package selenium4.features;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v110.emulation.Emulation;
import org.openqa.selenium.devtools.v110.emulation.model.DisplayFeature;
import org.openqa.selenium.devtools.v110.emulation.model.ScreenOrientation;
import org.openqa.selenium.devtools.v110.page.model.Viewport;
import org.testng.annotations.Test;

import base.Base;

public class DevToolsDeviceDemension extends Base{

static DevTools devTools;
	
	
	@Test(priority=1)
	public void amazon() throws InterruptedException {
		
		devTools = ((HasDevTools) driver).getDevTools();		
		devTools.createSession();
//		Map deviceMetrics = new HashMap()
//	      {{
//	            put("width", 300);
//	            put("height", 1000);
//	            put("mobile", true);
//	            put("deviceScaleFactor", 50);
//	      }};
	       
	    devTools.createSession();

	    devTools.send(Emulation.setDeviceMetricsOverride(300, 1000, 50, true, Optional.<Number> empty(),
                Optional.<Integer> empty(), Optional.<Integer> empty(), Optional.<Integer> empty(), 
                Optional.<Integer> empty(), Optional.<Boolean> empty(), Optional.<ScreenOrientation> empty(), 
                Optional.<Viewport> empty(), Optional.<DisplayFeature> empty()));
	    
	    //((ChromiumDriver) driver).executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
        
        driver.get("https://amazon.com");
	}	
}
