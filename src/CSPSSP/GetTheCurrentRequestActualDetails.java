package CSPSSP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import actions.selenium.Browser;
import java.util.*;

class GetTheCurrentRequestActualDetails{
    public List<String> run(HashMap<String, Object> params){
         String JobName =  Browser.Driver.findElement(By.xpath(".//table/tbody/tr[1]/td[2]/div")).getText();
         String RequestedBy =  Browser.Driver.findElement(By.xpath(".//table/tbody/tr[1]/td[3]/div")).getText();
         String CreatedDate =  Browser.Driver.findElement(By.xpath(".//table/tbody/tr[1]/td[4]/div")).getText();
         String ScheduledTime =  Browser.Driver.findElement(By.xpath(".//table/tbody/tr[1]/td[5]/div")).getText();
         String Status =  Browser.Driver.findElement(By.xpath(".//table/tbody/tr[1]/td[6]/div")).getText();
            
		List<String> currentRequestDetails = new ArrayList<String>();
        currentRequestDetails.add(JobName);
        currentRequestDetails.add(RequestedBy);
        currentRequestDetails.add(CreatedDate);
        currentRequestDetails.add(ScheduledTime);
        currentRequestDetails.add(Status);
        if((params.get("Status").toString()).equals("Scheduled"))
        {
        String Action =  Browser.Driver.findElement(By.xpath(".//table/tbody/tr[1]/td[7]/div/a")).getText();
        currentRequestDetails.add(Action);
        }
		
		return currentRequestDetails;
    }
        
}