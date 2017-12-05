package CSPSSP;

import java.util. * ;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;
import actions.selenium.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium. * ;

class WaitUntilNotifceSentorTimeOut {
	public void run(HashMap < String, Object > params)throws Exception {
	
		long seconds = 0;
		long minutes = 0;
		long maxSeconds = 300;
		String status;
		String sentAt;

		String notificationName = Browser.Driver.findElement(By.xpath("//div[@data-mgcompnamevalue='NameGridCol']")).getText();
		String[]name = notificationName.split("-");
		String notificationDate = name[9];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d-HH:mm:ss");
//		Date scheduledTime = sdf.parse(notificationDate);
		long scheduledTime = sdf.parse(notificationDate).getTime()/1000;
		long lastPermissibleSendTime = scheduledTime + maxSeconds;
		
		TimeZone tz = TimeZone.getDefault();  
		Calendar cal = GregorianCalendar.getInstance(tz);
		int offsetInSeconds = tz.getOffset(cal.getTimeInMillis()) / 1000;
System.out.println("offsetInSeconds=" + offsetInSeconds);
System.out.println("lastPermissibleSendTime=" + lastPermissibleSendTime);
System.out.println("scheduledTime=" + scheduledTime);
System.out.println("notificationDate=" + notificationDate);



		while (true) {
			//String scheduledTime;
			long timeNow = System.currentTimeMillis() % 1000;
System.out.println("timeNow =" + timeNow);
			status = Browser.Driver.findElement(By.xpath("//div[@data-mgcompnamevalue='StatusGridCol']")).getText();
System.out.println("status=" + status);
			if (status.equalsIgnoreCase("Failed")) {
				Assert.fail("Notification failed");
System.out.println("Inside Fail"			);
			}
			if (status.equalsIgnoreCase("SCHEDULED")) {
System.out.println("inside Scheduled");
//				String scheduledEle = Browser.Driver.findElement(By.xpath("//div[@data-mgcompnamevalue='ScheduledTimeGridCol']")).getText();
//				while (!scheduledEle.isEmpty()) {}
				if (timeNow > lastPermissibleSendTime) {
					Assert.fail("Notification Timed out before being sent.");
				}
			}



//			Calendar calender = new GregorianCalendar();
//			calender.setTime(scheduledTime);
//			calender.add(Calendar.HOUR, 5);
//			Date date = calender.getTime();

//			long timeDiff = sentDate.getTime() - date.getTime();
//			seconds = TimeUnit.MILLISECONDS.toSeconds(timeDiff);

			if (status.equalsIgnoreCase("Completed")) {
System.out.println("InsideCompleted");
			sentAt = Browser.Driver.findElement(By.xpath(
			"//td[@data-mgcompname='UpdatedBycol']/following-sibling::td[@data-mgcompname='SentAtGridCol']/div")).getText();
System.out.println("sentAt=" + sentAt);
//				Date sentDate = sdf.parse(sentAt);
				long sentTime = sdf.parse(sentAt).getTime()/1000 - offsetInSeconds;
System.out.println("sendTime="+sentTime);

				if (sentTime > lastPermissibleSendTime) {
					Assert.fail("The Notification was sent but the delay in sending was more than permitted.");
				}
				return;
			}


			Thread.sleep(15000);
			WebElement refreshButton = Browser.Driver.findElement(By.xpath("//div[@data-mgcompname='refreshButton']//button"));
			refreshButton.click();
		}
	}
}
		
		
		
		
		
		
		
		
		