package CSPSSP;

import actions.selenium.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import java.util.*;
import org.junit.Assert;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.DateFormat;

class WaitUntilNoticeOrTimeOut{
    public void run(HashMap<String, Object> params){
        String status;
        Date timeNow=null,lastDateTime=null;
        status = Browser.Driver.findElement(By.xpath("//div[@data-mgcompnamevalue='StatusGridCol']")).getText(); 
       	SimpleDateFormat CreatedDate = new SimpleDateFormat("yyyy-M-d-HH:mm:ss");
		Calendar c = Calendar.getInstance();
		try{
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");

			// Use Madrid's time zone to format the date in
			df.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));
            String date=df.format(new Date());
            timeNow=(Date)df.parse(date);
            
            //LastTime
            c.setTime((Date)CreatedDate.parse(params.get("ScheduledTime").toString()));
            c.add(Calendar.MINUTE, Integer.parseInt(params.get("AddMinutes").toString()));
            lastDateTime=c.getTime();
            
        }
        catch(Exception e){
            Assert.fail("Date Parsing failed");
        }
        
        if(status.equalsIgnoreCase("Completed")){
            if(timeNow.after(lastDateTime)){
                Assert.fail("Notification timed out");
				
			}
        }
        else if(status.equalsIgnoreCase("Scheduled")&&timeNow.after(lastDateTime)){
            Assert.fail("Notification timed out");
            
        }
        
        else if(status.equalsIgnoreCase("Scheduled")&&timeNow.before(lastDateTime)){
            String sentAt=Browser.Driver.findElement(By.xpath("//div[@data-mgcompnamevalue='SentAtGridCol' and @class='x-grid-cell-inner ']")).getText();
            try{
            c.setTime((Date)CreatedDate.parse(sentAt));}
            catch(Exception e){}
            if(c.getTime().after(lastDateTime)){
                Assert.fail("Notification timed out");
            }
            
        }
        else if(status.equalsIgnoreCase("Failed")){
            Assert.fail("Notification failed");
        }
        else
            Assert.fail("Invalid status found");
        
    }
}