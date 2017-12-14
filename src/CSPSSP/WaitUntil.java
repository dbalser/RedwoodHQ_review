package CSPSSP;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.DateFormat;
import org.junit.Assert;
import actions.selenium.Browser;
import org.openqa.selenium.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

class WaitUntil{
    public String run(HashMap<String, Object> params){
        
		Calendar c = Calendar.getInstance();
		String dte1="",dte2="";
        String[]name = params.get("NotificationName").toString().split("@");
		String notificationDate = name[1];
		System.out.println(notificationDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d-HH:m:s");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-M-d HH:m:s");
      
        /*try{
            Date dt=sdf.parse(notificationDate);
            System.out.println(dt);
            c.setTime(dt);
            c.add(Calendar.SECOND, Integer.parseInt(params.get("Offset").toString()));
            dte1=sdf1.format(c.getTime());
            dte2=sdf.format(c.getTime());
        }
        catch(Exception e){
            Assert.fail("Date parsing failed"); 
        }
		System.out.println(dte1);
       // dt="2017-11-12$04:05:11";
        String[]dtime=dte1.split(" ");
        
        String dte=dtime[0];
        String[]tm=(dtime[1]).split(":");
        */
        String[] tm=notificationDate.split(":");
        String hr=tm[0];
        String mn=tm[1];
        
        WebElement sendNow=null,sendAt=null,date=null,hour=null,min=null,timezone=null,btnSchedule=null,btnYes=null,btnOk=null;
        WebElement hourDropdown=null,minuteDropdown=null,timeZoneDropdown=null,nname=null;
        String newName=params.get("NotificationName").toString();//name[0]+"@"+dte2;
        
        if(Integer.parseInt(params.get("Offset").toString())<=0){
            Browser.Driver.findElement(By.xpath("//button[@data-mgcompnamevalue='savebutton']")).click();
            Browser.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
             new WebDriverWait(Browser.Driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-mgcompnamevalue='runOnOption']/../span")));
            sendNow=Browser.Driver.findElement(By.xpath("//input[@data-mgcompnamevalue='runNowOption']/../span"));
            sendNow.click();
        }
        else if(Integer.parseInt(params.get("Offset").toString())>0)
        {
            //nname=Browser.Driver.findElement(By.xpath("//input[@data-mgcompnamevalue='Name']"));
            //nname.clear();
            //nname.sendKeys(newName);
            
            if(params.get("IsFromScratch").toString().equals("Yes")){
                Browser.Driver.findElement(By.xpath("//button[@data-mgcompnamevalue='savebutton']")).click();
                //try{
               // 	Thread.sleep(8);	}
                //catch(Exception e){Assert.fail("Failed in waiting after save");}
               new WebDriverWait(Browser.Driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-mgcompnamevalue='runOnOption']/../span")));
            }
            
            sendAt=Browser.Driver.findElement(By.xpath("//input[@data-mgcompnamevalue='runOnOption']/../span"));
            sendAt.click();
            
            date=Browser.Driver.findElement(By.xpath("//input[@data-mgcompnamevalue='runOnDate']"));
            date.sendKeys(dte);
            
            hourDropdown=Browser.Driver.findElement(By.xpath("//input[@data-mgcompnamevalue='runOnTimeHr']/../../div[2]"));
            hourDropdown.click();
            try{
            Thread.sleep(3000);}
            catch(Exception e){
                
                Assert.fail("Failed in waiting");
            }
            
            hour=Browser.Driver.findElement(By.xpath("//div[@data-mgcompname='runOnTimeHr']//td[contains(text(),'"+hr+"')]"));
            hour.click();
            
            minuteDropdown=Browser.Driver.findElement(By.xpath("//div[@data-mgcompname='runOnTimeMin']/div/div/div[2]"));
            minuteDropdown.click();
            
            min=Browser.Driver.findElement(By.xpath("//div[@data-mgcompname='runOnTimeMin']//td[contains(text(),'"+mn+"')]"));
            min.click();
            
            timeZoneDropdown=Browser.Driver.findElement(By.xpath("//input[@data-mgcompnamevalue='runOnTimeZoneName']/../../div[2]"));
            timeZoneDropdown.click();
             
            Browser.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            timezone=Browser.Driver.findElement(By.xpath("//td[contains(text(),'"+params.get("RequiredTimeZone").toString()+"')]"));
            timezone.click();
            
            
        }
        else
            Assert.fail("Invalid action passed in arguments");
       
        
        return newName;
    }
}