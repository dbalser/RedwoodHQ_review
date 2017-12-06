package CSPSSP;

import actions.selenium.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import java.util.*;
import org.junit.Assert;

class VerifyNotification{
    public String run(HashMap<String, Object> params){
        WebElement element= null;
        List<WebElement> table=null;
        String str=params.get("Text").toString();
        List<String> items = Arrays.asList(str.split("\\s*,\\s*"));
		String tabName,gridName;
        if(params.get("Category").toString().equals("Sent")){
			tabName = "notebookTabSent";
            gridName = "SentGrid";
        } else if(params.get("Category").toString().equals("Bounced")){
			tabName = "notebookTabBounced";
            gridName = "BouncedGrid";
        } else if (params.get("Category").toString().equals("Not Sent")){
			tabName = "notebookTabNotSent";
            gridName = "NotSentGrid";
        } else {
            return "Invalid category";            
        }
        Browser.Driver.manage().timeouts().implicitlyWait(1, java.util.concurrent.TimeUnit.SECONDS);
        element = Browser.Driver.findElement(By.xpath(".//span[@data-mgcompnamevalue='" + tabName + "']")); 
        element.click();
		//please see if you can find better locators.  It may not be possible, but please try.
        table = Browser.Driver.findElements(By.xpath("//div[@data-mgcompname='" + gridName + "']//table//td[@data-mgcompname='SentAtGridCol']")); 
	    Browser.Driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
        if(table.size()!=Integer.parseInt(params.get("Count").toString()))
            Assert.fail("Count on UI with number of emails passed not matching");
        if(str!=""){
            for(int j=0;j<table.size();j++){ 
                    String txt=Browser.Driver.findElement(By.xpath("//div[@data-mgcompname='" + gridName + "']//table["+(j+1)+"]//td[@data-mgcompname='SentEmailGridCol']/div")).getText();
                    if(!txt.equals(items.get(j).toString()))
                    {
                        Assert.fail("Email id "+items.get(j).toString()+" not found on UI");
                    }
            }
        }
        return "Not found";
        
    }
}