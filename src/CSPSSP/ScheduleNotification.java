package CSPSSP;

import java.util.*;
import org.junit.Assert;
import actions.selenium.Browser;
import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

class ScheduleNotification{
    public void run(HashMap<String, Object> params){
        
        WebElement btnSchedule=null, btnYes=null, btnOk=null;
        String newName=params.get("NotificationName").toString();
        
        btnSchedule=Browser.Driver.findElement(By.xpath("//button[@data-mgcompnamevalue='savebutton']"));
        btnSchedule.click();
        
        Browser.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
        btnYes=Browser.Driver.findElement(By.xpath("//button[@data-mgcompnamevalue='YesBtn']"));
        btnYes.click();

        Browser.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        new WebDriverWait(Browser.Driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'OK')]")));
    	btnOk=Browser.Driver.findElement(By.xpath("//span[contains(text(),'OK')]"));
        
        btnOk.click();
        
        WebElement statusDropdown=null,status=null,search=null,btnSearch=null,row=null;
        
        statusDropdown=Browser.Driver.findElement(By.xpath("//div[@data-mgcompname='NotificationStatusDropList']/div/div/div[2]"));
        statusDropdown.click();
        
        status=Browser.Driver.findElement(By.xpath("//td[contains(text(),'All')]"));
        status.click();
        
        search=Browser.Driver.findElement(By.xpath("//input[@data-mgcompnamevalue='SearchEdit']"));
        search.sendKeys(newName);
        
        btnSearch=Browser.Driver.findElement(By.xpath("//button[@data-mgcompnamevalue='btnSearch']"));
        btnSearch.click();
        
        try{
        	row=Browser.Driver.findElement(By.xpath("//div[contains(text(),'"+newName+"')]"));
        }
        catch(Exception e)
        {
            Assert.fail("Notification name is not found in list");
        }
        
    }
}