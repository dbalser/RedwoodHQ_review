package CSPSSP;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import actions.selenium.Browser;
import java.util.*;

class SelectDateFromCalendar{
    public void run(HashMap<String, Object> params){
        
        String strDate = null;
        
        if(params.get("DateType").toString().equals("Tomorrow"))
        {
        Date today = new Date();
		Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));  
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	    strDate= formatter.format(tomorrow);  
        }
        else if(params.get("DateType").equals("CustomDate"))
        {
            strDate = params.get("CustomDate").toString();
        }
	   		
		Map<String,String>months=new HashMap<String,String>();
		months.put("01", "January");months.put("02", "February");months.put("03", "March");months.put("04", "April");months.put("05", "May");months.put("06", "June");months.put("07", "July");months.put("08", "August");months.put("09", "September");months.put("10", "October");months.put("11", "November");months.put("12", "December");
		
		String inputDate = strDate;
		 String date[]=inputDate.split("/");
		
        if(date[1].charAt(0) == '0')
		 {
			date[1] = date[1].replace("0", "");
		 }
        
		String expectedDay = date[1];
		String expectedMonthYear = months.get(date[0])+date[2];
        		
		boolean stopMonthIteration = false;
		while(!stopMonthIteration)
		{
			String actualmonth = Browser.Driver.findElement(By.xpath(".//span[@class='month']")).getText();
			String actualYear = Browser.Driver.findElement(By.xpath(".//span[@class='year']")).getText();
			String actualMonthYear = actualmonth+actualYear;

			if(expectedMonthYear.equals(actualMonthYear))
			{
				stopMonthIteration = true;
			}
			else
			{
				Browser.Driver.findElement(By.xpath("//*[@id='calendar-popup']/div[2]/div/div[1]/button[2]")).click();
			}
		
		}
		
		WebElement table = Browser.Driver.findElement(By.xpath(".//table[@class='calendar-table']"));
		WebElement tbody =table.findElement(By.tagName("tbody"));
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		
		for(int i=0;i<rows.size();i++)
		{
			boolean breakOuterLoop = false;
		List<WebElement> cols =rows.get(i).findElements(By.tagName("td"));
		for(int j=0;j<cols.size();j++)
		{
            if((cols.get(j).getAttribute("class").equals("alternate prev-month")) ||(cols.get(j).getAttribute("class").equals("alternate next-month")))  
			{
			}
			else
			{
			if(cols.get(j).getText().equals(expectedDay))
			{
				cols.get(j).click();
				breakOuterLoop = true;
				break;
			}
			}
               
		}
		
		if(breakOuterLoop){break;}
		
		}
    }
}