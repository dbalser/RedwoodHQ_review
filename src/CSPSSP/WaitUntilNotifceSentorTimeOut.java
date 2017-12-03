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
/*
      long seconds = 0;
      long minutes = 0;
      long maxSeconds = 300;
      long timeNow;

      while (true) {
        String status;
        String sentAt;
        //String scheduledTime;

        status = Browser.Driver.findElement(By.xpath("//div[@data-mgcompnamevalue='StatusGridCol']")).getText();

        if(status.equalsIgnoreCase("Failed")){
          Assert.fail("Notification failed");
        }

        String notificationName = Browser.Driver.findElement(By.xpath("//div[@data-mgcompnamevalue='NameGridCol']")).getText();
        String[] name = notificationName.split("-");
        String notificationDate = name[9];
        Date schedule = sdf.parse(notificationDate);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d-HH:mm:ss");

        sentAt = Browser.Driver.findElement(By.xpath("//td[@data-mgcompname='UpdatedBycol']/following-sibling::td[@data-mgcompname='SentAtGridCol']/div").getText(); 
        Date sentDate = sdf.parse(sentAt);

        Calendar calender = new GregorianCalendar();
        calender.setTime(schedule);
        calender.add(Calendar.HOUR, 5);
        Date date = calender.getTime();

        long timeDiff = sentDate.getTime() - date.getTime();
        seconds = TimeUnit.MILLISECONDS.toSeconds(timeDiff);
        timeNow = System.currentTimeMillis();
           

        if(status.equalsIgnoreCase("Completed")){
          if(seconds > maxSeconds){
            Assert.fail("Notification failed and the time difference is "+seconds+" seconds.");
          }
          return
        }
        
        if(status.equalsIgnoreCase("SCHEDULED")){
          String scheduledEle = Browser.Driver.findElement(By.xpath("//div[@data-mgcompnamevalue='ScheduledTimeGridCol']")).getText();
          while(!scheduledEle.isEmpty()){
          }
          if(seconds > 300){
              Assert.fail("Notification failed, the time difference is "+seconds+" seconds.");
          }
        }
        
        Thread.sleep(15000);
        WebElement refreshButton = Browser.Driver.findElement(By.xpath("//div[@data-mgcompname='refreshButton']//button"));
        refreshButton.click();         
      } */ 
    }
}






