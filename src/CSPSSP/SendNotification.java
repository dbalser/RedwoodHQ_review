package CSPSSP;

import java.util.*;
import actions.selenium.Browser;
import org.openqa.selenium.*;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;



class SendNotification{
    public void run(HashMap<String, Object> params) throws Exception{
        WebElement sendNow=null,sendAt=null,date=null,hour=null,min=null,timezone=null,btnSchedule=null,btnYes=null,btnOk=null;
        WebElement hourDropdown=null,minuteDropdown=null,timeZoneDropdown=null;
        
        if(params.get("Action").toString().equals("SendNow"))
        {
            sendNow=Browser.Driver.findElement(By.xpath("//input[@data-mgcompnamevalue='runNowOption']/../span"));
            sendNow.click();
        }
        else if(params.get("Action").toString().equals("SendAt"))
        {
            sendAt=Browser.Driver.findElement(By.xpath("//input[@data-mgcompnamevalue='runOnOption']/../span"));
            sendAt.click();
            
            date=Browser.Driver.findElement(By.xpath("//input[@data-mgcompnamevalue='runOnDate']"));
            date.sendKeys(params.get("RequiredDate").toString());
            
            hourDropdown=Browser.Driver.findElement(By.xpath("//input[@data-mgcompnamevalue='runOnTimeHr']/../../div[2]"));
            hourDropdown.click();
            Thread.sleep(3000);
            
            hour=Browser.Driver.findElement(By.xpath("//div[@data-mgcompname='runOnTimeHr']//td[contains(text(),'"+params.get("RequiredHour").toString()+"')]"));
            hour.click();
            
            minuteDropdown=Browser.Driver.findElement(By.xpath("//div[@data-mgcompname='runOnTimeMin']/div/div/div[2]"));
            minuteDropdown.click();
            
            min=Browser.Driver.findElement(By.xpath("//div[@data-mgcompname='runOnTimeMin']//td[contains(text(),'"+params.get("RequiredMinute").toString()+"')]"));
            min.click();
            
            timeZoneDropdown=Browser.Driver.findElement(By.xpath("//input[@data-mgcompnamevalue='runOnTimeZoneName']/../../div[2]"));
            timeZoneDropdown.click();
                
            timezone=Browser.Driver.findElement(By.xpath("//td[contains(text(),'"+params.get("RequiredTimeZone").toString()+"')]"));
            timezone.click();
            
            
        }
        else
            Assert.fail("Invalid action passed in arguments");
        
        btnSchedule=Browser.Driver.findElement(By.xpath("//button[@data-mgcompnamevalue='savebutton']"));
        btnSchedule.click();
        
        Browser.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
        btnYes=Browser.Driver.findElement(By.xpath("//button[@data-mgcompnamevalue='YesBtn']"));
        btnYes.click();

    	btnOk=Browser.Driver.findElement(By.xpath("//span[contains(text(),'OK')]"));
        btnOk.click();
    }
}