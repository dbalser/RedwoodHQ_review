package actions.selenium

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

class JPSWaitForElement
{
    public void run (def params)
    {
        long startTime = System.currentTimeMillis()
        System.out.println("InTicks=" + (startTime % 100000)/1000 )
    
        int msCount = params."Timeout In Seconds".toInteger() * 1000
        def thisID = params."ID"
        System.out.println("Wait for element="+thisID)
    
        def wait = new WebDriverWait(Browser.driver, 20);
        
        def failCount = 0;
        
        while(msCount >= 0)
        {
            try
            {
                def elements = Elements.findAll(params,Browser.Driver)
                
                if(elements.size() > 1)
                {
                    System.out.println("Warning.  Multiple elements found.  Find a better locator." )      
                    System.out.println("Warning.  "+ elements.size() +" elements found." )      
                }
                
                if(elements.size() > 0) break
            }
            catch(org.openqa.selenium.WebDriverException err)
            {
                failCount += 1;
                System.out.println("++++>Caught Exception =" + err.message); 
                
                if (!(err.message.contains("mg-busy-wait") || //This may overcome refresh issues on mongoose autorefresh screens
                      err.message.contains("no such session") || 
                      err.message.contains("element not visible")) ||
                    (failCount > 100))
                {
                    long endTime = System.currentTimeMillis()
                    System.out.println("OutTicks=" + (endTime % 100000)/1000 )
                    System.out.println("====>Duration ="+ (endTime - startTime)/1000); System.out.println(" ")
                    throw err
                }
                
                sleep(1000) //after an exception, sleep longer
                msCount = msCount - 1000
            }
                  
            sleep(100)
            msCount = msCount - 100
        }
        
        if(msCount <= 0) {
            assert false,"Element was not found in ${params."Timeout In Seconds"} seconds."
        }
                  
        long endTime = System.currentTimeMillis()
        System.out.println("OutTicks=" + (endTime % 100000)/1000 )
        System.out.println("====>Duration ="+ (endTime - startTime)/1000); System.out.println(" ")
  }
}