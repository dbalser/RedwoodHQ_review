package actions.selenium

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class WaitForElement{
  public void run (def params){
  long startTime = System.currentTimeMillis()
  System.out.println("InTicks=" + (startTime % 100000)/1000 )
    
    int msCount = params."Timeout In Seconds".toInteger() * 1000
    while(msCount >= 0){
      def elements = Elements.findAll(params,Browser.Driver)
      if(elements.size() > 0) break
      sleep(100)
      msCount = msCount - 100
    }
    if(msCount <= 0){
      assert false,"Element was not found in ${params."Timeout In Seconds"} seconds."
    }
    long endTime = System.currentTimeMillis()
    System.out.println("OutTicks=" + (endTime % 100000)/1000 )
    System.out.println("====>Duration ="+ (endTime - startTime)/1000); System.out.println(" ")

  }
}