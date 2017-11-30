package CSPSSP;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;
import actions.selenium.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;


class WaitUntilNotifceSentorTimeOut{
    public void run(HashMap<String, Object> params){
        String status;
        String sentAt;
        String scheduledTime;
       	long seconds =0;
        long minutes = 0;
        long hours = 0;
        status = Browser.Driver.findElement(By.xpath("//div[@data-mgcompnamevalue='StatusGridCol']")).getText();
        sentAt = Browser.Driver.findElement(By.xpath("//td[@data-mgcompname='UpdatedBycol']/following-sibling::td[@data-mgcompname='SentAtGridCol']/div")).getText(); 
        String notificationName = Browser.Driver.findElement(By.xpath("//div[@data-mgcompnamevalue='NameGridCol']")).getText();
        String[] name = notificationName.split("-");
        String notificationDate = name[9];
        
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d-HH:mm:ss");
           	
       		Date sentDate = sdf.parse(sentAt);
            Date schedule = sdf.parse(notificationDate);
            
        	Calendar calender = new GregorianCalendar();
       		calender.setTime(schedule);
       		calender.add(Calendar.HOUR, 5);
       		Date date = calender.getTime();
            
            long timeDiff = sentDate.getTime() - date.getTime();
            seconds = TimeUnit.MILLISECONDS.toSeconds(timeDiff);
       		minutes = TimeUnit.MILLISECONDS.toMinutes(timeDiff);
       		hours = TimeUnit.MILLISECONDS.toHours(timeDiff);
        }
        catch(Exception e){
            
        }
        if(status.equalsIgnoreCase("Completed")){
            if(hours!=0 & minutes > 5){
                Assert.fail("Notification failed and the time difference is "+hours+" hours "+minutes+" minutes and "+seconds+" seconds.");
            }
        }
        
        if(status.equalsIgnoreCase("SCHEDULED")){
            int count =0;
            try{
                for(int i=1; i<=20; i++){
                    System.out.println("Loop count "+i);
                    String scheduledEle = Browser.Driver.findElement(By.xpath("//div[@data-mgcompnamevalue='ScheduledTimeGridCol']")).getText();
                    WebElement refreshButton = Browser.Driver.findElement(By.xpath("//div[@data-mgcompname='refreshButton']//button"));
                    if(!scheduledEle.isEmpty()){
                        Thread.sleep(15000);
                        refreshButton.click();
                        count++;
                    }
                    else{
                        break;
                    }
                    if(count==20){
                     Assert.fail("Notification timed-out");
                	}
                }
            }catch(Exception e){
                
            }
            if(hours!=0 & minutes > 5){
                Assert.fail("Notification failed, the time difference is "+hours+" hours "+minutes+" minutes and "+seconds+" seconds.");
            }
        }  
        
         if(status.equalsIgnoreCase("Failed")){
              Assert.fail("Notification failed");
        }
        
    }
}