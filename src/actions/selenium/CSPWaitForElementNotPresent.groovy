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

   int msCount = params."Timeout In Seconds".toInteger() * 1000
    while(msCount >= 0){
      def elements = Elements.findAll(params,Browser.Driver)
      if(elements.size() > 1) {
      	System.out.println("Warning.  Multiple elements found.  Find a better locator." )      
      	System.out.println("Warning.  "+ elements.size() +" elements found." )      
      }
      if(elements.size() == 0) break
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
