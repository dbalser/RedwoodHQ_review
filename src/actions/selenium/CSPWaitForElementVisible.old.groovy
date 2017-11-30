package actions.selenium

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class CSPWaitForElementVisibleOld{
  public void run (def params){
   long startTime = System.currentTimeMillis()
   System.out.println("InTicks=" + (startTime % 100000)/1000 )
   def thisID = params."ID"
   System.out.println("Wait for element="+thisID)
    
   int msCount = params."Timeout In Seconds".toInteger() *1000
    while(msCount >= 0){
      def elements = Elements.findAll(params,Browser.Driver)
      if(elements.size() > 1) {
      	System.out.println("Warning.  Multiple elements found.  Find a better locator." )      
      	System.out.println("Warning.  "+ elements.size() +" elements found." )      
      }
      if(elements.size() > 0) {
	      System.out.println("el[0]=" + elements[0] + " el[0].id=" + elements[0].isDisplayed() + " el[0].ie=" + elements[0].isEnabled() + " el[0].class=" + elements[0].getAttribute('class') )
          if(elements[0].isDisplayed() &&
             elements[0].isEnabled() &&
             !(elements[0].getAttribute('class').contains('disabled'))    ) break
          if (msCount <= 200) break
      }
      sleep(100)
      msCount = msCount - 100
    }
    if(msCount <= 0){
      assert false,'Element was not found in ${params."Timeout In Seconds"} seconds.'
    }
    long endTime = System.currentTimeMillis()
    System.out.println("OutTicks=" + (endTime % 100000)/1000 )
    System.out.println("====>Duration ="+ (endTime - startTime)/1000); System.out.println(" ")

 }
}