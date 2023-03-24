package selenium4.features;

import java.util.Optional;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v110.network.Network;
import org.openqa.selenium.devtools.v110.network.model.Request;
import org.testng.annotations.Test;

import base.Base;

public class DevToolsNetworkLog extends Base{

static DevTools devTools;
	
	@Test
	public void networkLogs() {
		
		devTools = ((HasDevTools) driver).getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devTools.addListener(Network.requestWillBeSent(), request ->
		{
			Request req = request.getRequest();
			//System.out.println(req.getUrl());

		});
		
		
		devTools.addListener(Network.responseReceived(), response ->
		{
			org.openqa.selenium.devtools.v110.network.model.Response res = response.getResponse();
			//System.out.println(res.getUrl());
			//System.out.println(res.getStatus());
			
			if(res.getStatus().toString().startsWith("4"))
			{
				System.out.println(res.getUrl()+"-- is failing with error code: "+res.getStatus());
			}
		});
		
        driver.get("https://google.com");
	}
}
