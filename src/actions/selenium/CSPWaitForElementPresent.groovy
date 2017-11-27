package actions.selenium

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import groovy.time.*

class CSPWaitForElementPresent{
  public void run (def params){
    long startTime = System.currentTimeMillis()
    System.out.println("InTicks=" + (startTime % 100000)/1000 )
    def thisID = params."ID"
    System.out.println("Wait for element="+thisID)
    
    int msCount = params."Timeout In Seconds".toInteger() * 1000
	def failCount = 0;
    while(msCount >= 0){
      System.out.println("Inside WFEP Loop. msCount="  + msCount)
      try {
	    def elements = Elements.findAll(params,Browser.Driver)
        if(elements.size() > 1) {
        	System.out.println("Warning.  Multiple elements found.  Find a better locator." )      
        	System.out.println("Warning.  "+ elements.size() +" elements found." )      
        }
          if(elements.size() > 0) {
	      System.out.println("el[0]=" + elements[0] + " el[0].id=" + elements[0].isDisplayed() + " el[0].ie=" + elements[0].isEnabled() + " el[0].class=" + elements[0].getAttribute('class') )
		  break
        }
      }
      catch(org.openqa.selenium.WebDriverException err){
		failCount += 1;
        System.out.println("++++>Caught Exception =" + err.message); 
        if (!(err.message.contains("mg-busy-wait") || //This may overcome refresh issues on mongoose autorefresh screens
     	  err.message.contains("no such session") || //This is the important one to catch
          err.message.contains("element not visible")) ||
          (failCount > 10)){
		    long endTime = System.currentTimeMillis()
            System.out.println("OutTicks=" + (endTime % 100000)/1000 )
            System.out.println("====>Duration ="+ (endTime - startTime)/1000); System.out.println(" ")
            throw err
        }
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