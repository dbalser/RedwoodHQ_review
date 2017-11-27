package actions.selenium

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import groovy.time.*
    
class CSPWaitForElement{
  public void run (def params){
  long startTime = System.currentTimeMillis()
  System.out.println("InTicks=" + (startTime % 100000)/1000 )
//  System.out.println(+ "InTicks=" + (System.currentTimeMillis()%100000)/*.intdiv(10) */)
    
   int msCount = params."Timeout In Seconds".toInteger() * 1000
    while(msCount >= 0){
      def elements = Elements.findAll(params,Browser.Driver)
      System.out.println("Inside WFE Loop msCount=" + msCount)
      System.out.println("Inner ticks=" + (System.currentTimeMillis() % 100000)/1000 )
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