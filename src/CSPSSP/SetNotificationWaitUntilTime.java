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

class SetNotificationWaitUntilTime{
    public void run(HashMap<String, Object> params){
        
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
       */
        
        
        
        WebElement sendNow=null,sendAt=null,date=null,hour=null,min=null,timezone=null,btnSchedule=null,btnYes=null,btnOk=null;
        WebElement hourDropdown=null,minuteDropdown=null,timeZoneDropdown=null,nname=null,emailCheckbox=null;
        String newName=params.get("NotificationName").toString();//name[0]+"@"+dte2;
        
        if(Integer.parseInt(params.get("Offset").toString())<=0){
             new WebDriverWait(Browser.Driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-mgcompnamevalue='runOnOption']/../span")));
            sendNow=Browser.Driver.findElement(By.xpath("//input[@data-mgcompnamevalue='runNowOption']/../span"));
            sendNow.click();
            //Browser.Driver.findElement(By.xpath("//button[@data-mgcompnamevalue='savebutton']")).click();
        }
        else if(Integer.parseInt(params.get("Offset").toString())>0)
        {
            Calendar currentdate = Calendar.getInstance();
        int seconds = Integer.parseInt(params.get("Offset").toString());
        currentdate.add(Calendar.SECOND, seconds);
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		TimeZone obj = TimeZone.getTimeZone(params.get("TimeZoneFormat").toString());
		formatter.setTimeZone(obj);
        String requiredTime = formatter.format(currentdate.getTime());
                System.out.println("requiredTime"+requiredTime);

        
        String[]dtime=requiredTime.split(" ");
        System.out.println("dtime"+dtime);

        
        String dte=dtime[0];
        String[] time=dte.split("-");
        String requiredDate = time[1]+"/"+time[0]+"/"+time[2];
                            System.out.println("requiredDate"+requiredDate);

        
        String[] tm=(dtime[1]).split(":");
        
        
        String hr=tm[0];
                    System.out.println("hr"+hr);

        String mn=tm[1];
                             System.out.println("mn"+mn);
   
            
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
            date.sendKeys(requiredDate);
            
            hourDropdown=Browser.Driver.findElement(By.xpath("//*[@data-mgcompnamevalue='runOnTimeHr']/../../div[2]"));
            try{
                System.out.println("entered into try");
            Thread.sleep(3000);
            hourDropdown.click();

            System.out.println(" finished try");
}
            catch(Exception e){
                
                Assert.fail("Failed in waiting");
            }
            
            hour=Browser.Driver.findElement(By.xpath("//*[@data-mgcompname='runOnTimeHr']//td[contains(text(),'"+hr+"')]"));
             try{
                System.out.println("entered into try");
            Thread.sleep(3000);
            //hour.click();

            System.out.println(" finished try");
}
            catch(Exception e){
                
                Assert.fail("Failed in waiting");
            }
            minuteDropdown=Browser.Driver.findElement(By.xpath("//*[@data-mgcompname='runOnTimeMin']/div/div/div[2]"));
             try{
                System.out.println("entered into try");
            Thread.sleep(3000);
             minuteDropdown.click();

            System.out.println(" finished try");
}
            catch(Exception e){
                
                Assert.fail("Failed in waiting");
            }
            min=Browser.Driver.findElement(By.xpath("//div[@data-mgcompname='runOnTimeMin']//td[contains(text(),'"+mn+"')]"));
            try{
                System.out.println("entered into try");
            Thread.sleep(3000);
            min.click();

            System.out.println(" finished try");
}
            catch(Exception e){
                
                Assert.fail("Failed in waiting");
            }
            
            timeZoneDropdown=Browser.Driver.findElement(By.xpath("//input[@data-mgcompnamevalue='runOnTimeZoneName']/../../div[2]"));
             try{
                System.out.println("entered into try");
            Thread.sleep(3000);
            timeZoneDropdown.click();

            System.out.println(" finished try");
}
            catch(Exception e){
                
                Assert.fail("Failed in waiting");
            }
             
            timezone=Browser.Driver.findElement(By.xpath("//td[contains(text(),'"+params.get("RequiredTimeZone").toString()+"')]"));
            new WebDriverWait(Browser.Driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+params.get("RequiredTimeZone").toString()+"')]")));
            try{
                System.out.println("entered into try");
            Thread.sleep(3000);
            timezone.click();

            System.out.println(" finished try");
}
            catch(Exception e){
                
                Assert.fail("Failed in waiting");
            }
            
            
            //emailCheckbox=Browser.Driver.findElement(By.xpath("//*[@data-mgcompnamevalue='EmailCheckBox']/../span"));
           // emailCheckbox.click();
            
            
        }
        else
            Assert.fail("Invalid action passed in arguments");
       
        
    }
}