package actions.selenium

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class CSPWaitForElementNotPresent{
  public void run (def params){
    long startTime = System.currentTimeMillis()
    System.out.println("InTicks=" + (startTime % 100000)/1000 )
    def thisID = params."ID"
    System.out.println("Wait for element="+thisID)

//   Browser.Driver.manage().timeouts().implicitlyWait(0, java.util.concurrent.TimeUnit.SECONDS)

	def failCount = 0;
    int msCount = params."Timeout In Seconds".toInteger() * 1000
    while(msCount >= 0){
      try {
          def elements = Elements.findAll(params,Browser.Driver)
		  if(elements.size() == 0) break
          if(elements.size() > 1) {
            System.out.println("Warning.  Multiple elements found.  Find a better locator." )      
            System.out.println("Warning.  "+ elements.size() +" elements found." )      
          }
      }
      catch(org.openqa.selenium.WebDriverException err){
		failCount += 1;
        System.out.println("++++>Caught Exception =" + err.message); 
        if (!(err.message.contains("mg-busy-wait") || //This may overcome refresh issues on mongoose autorefresh screens
     	  err.message.contains("no such session") || //this is the most important item that we are handling here. 
          err.message.contains("element not visible")) ||
          (failCount > 100)){
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
    if(msCount <= 0){
      assert false,"Element was still found after ${params."Timeout In Seconds"} seconds."
    }
//   Browser.Driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS)
   long endTime = System.currentTimeMillis()
   System.out.println("OutTicks=" + (endTime % 100000)/1000 )
   System.out.println("====>Duration ="+ (endTime - startTime)/1000); System.out.println(" ")
}
}
