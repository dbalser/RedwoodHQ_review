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
    public void run(HashMap<String, Object> params) throws Exception{
        String status;
        String sentAt;
        //String scheduledTime;
       	long seconds = 0;
        long minutes = 0;

        status = Browser.Driver.findElement(By.xpath("//div[@data-mgcompnamevalue='StatusGridCol']")).getText();
        sentAt = Browser.Driver.findElement(By.xpath("//td[@data-mgcompname='UpdatedBycol']/following-sibling::td[@data-mgcompname='SentAtGridCol']/div")).getText(); 
        String notificationName = Browser.Driver.findElement(By.xpath("//div[@data-mgcompnamevalue='NameGridCol']")).getText();
        String[] name = notificationName.split("-");
        String notificationDate = name[9];
        
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d-HH:mm:ss");
           	
       		Date sentDate = sdf.parse(sentAt);
            Date schedule = sdf.parse(notificationDate);
            
        	Calendar calender = new GregorianCalendar();
       		calender.setTime(schedule);
       		calender.add(Calendar.HOUR, 5);
       		Date date = calender.getTime();
            
            long timeDiff = sentDate.getTime() - date.getTime();
            seconds = TimeUnit.MILLISECONDS.toSeconds(timeDiff);
            
           

        if(status.equalsIgnoreCase("Completed")){
            if(seconds > 300){
                Assert.fail("Notification failed and the time difference is "+seconds+" seconds.");
            }
        }
        
        if(status.equalsIgnoreCase("SCHEDULED")){
           long count =0;
                for(int i=1; i<=minutes; i++){
                    String scheduledEle = Browser.Driver.findElement(By.xpath("//div[@data-mgcompnamevalue='ScheduledTimeGridCol']")).getText();
                    WebElement refreshButton = Browser.Driver.findElement(By.xpath("//div[@data-mgcompname='refreshButton']//button"));
                    while(!scheduledEle.isEmpty()){
                       Thread.sleep(15000);
                       refreshButton.click(); 
                    }
                    //if(!scheduledEle.isEmpty()){
                        
                        //count++;
                   // }
                    //else{
                        //break;
                   // }
                   
                }
            if(seconds > 300){
                Assert.fail("Notification failed, the time difference is "+seconds+" seconds.");
            }
        }  
        
         if(status.equalsIgnoreCase("Failed")){
              Assert.fail("Notification failed");
        }
        
    }
}