package actions.selenium

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

class JPSWaitForElement
{
    def static By locatorWithIDAndType(id, type)
    {
        def locator;
        
        switch (type.toLowercase())
        {
            case "id":
            	locator = By.Id(id)
            break
            
            case "xpath":
            	locator = By.XPath(id)
            break
            
            case "class name":
            	locator = By.ClassName(id)
            break
            
            case "tag name":
            	locator = By.TagName(id)
            break
            
            case "css selector":
            	locator = By.CssSelector(id)
            break
            
            case "link text":
            	locator = By.LinkText(id)
            break
            
            case "partial link text":
            	locator = By.PartialLinkText(id)
            break
            
            case "name":
            	locator = By.Id(id)
            break
        }

        return locator
    }
    
    public void run (def params)
    {
        long startTime = System.currentTimeMillis()
        System.out.println("InTicks=" + (startTime % 100000)/1000 )
    
        int msCount = params."Timeout In Seconds".toInteger() * 1000
        def id = params."ID"
        System.out.println("Wait for element="+id)
    
        def idType = params."".toString()
        def timeout = params."Timeout In Seconds".toInteger()
        def wait = new WebDriverWait(Browser.driver, timeout);
        
        def locator = JPSWaitForElement.locatorWithIDAndType(id, idType)
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
           
        long endTime = System.currentTimeMillis()
        System.out.println("OutTicks=" + (endTime % 100000)/1000 )
        System.out.println("====>Duration ="+ (endTime - startTime)/1000); System.out.println(" ")
  }
}