package selenium4.features;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v110.fetch.Fetch;
import org.testng.annotations.Test;

import base.Base;

public class DevToolsNetwrokMocking extends Base{

static DevTools devTools;
	
	@Test
	public void networkLogs() {
		
		devTools = ((HasDevTools) driver).getDevTools();
		devTools.createSession();
		
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		devTools.addListener(Fetch.requestPaused(), request ->
		{
			if(request.getRequest().getUrl().contains("shetty"))
			{
				String newurl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println(newurl);
				
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(newurl), Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));
			}
			else
			{
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));

			}
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		driver.findElement(By.xpath("//*[text()=' Virtual Library ']")).click();
	}
}
