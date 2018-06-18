package CSPSSP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import actions.selenium.Browser;
import java.util.*;

class GenerateNextRequestId{
    public String run(HashMap<String, Object> params){
        
        WebElement table =  Browser.Driver.findElement(By.xpath(".//table"));
		WebElement tbody =table.findElement(By.tagName("tbody"));
		int rowssize = tbody.findElements(By.tagName("tr")).size();
		
		List<String> requestids = new ArrayList<String>();
		
		for(int i =1;i<=rowssize;i++)
		{
			String requesid =  Browser.Driver.findElement(By.xpath(".//table/tbody/tr["+i+"]/td[1]/div")).getText();
			requestids.add(requesid);
		}
		
		return  (new Integer((Integer.parseInt(requestids.get(0))+1))).toString();
               
    }
}