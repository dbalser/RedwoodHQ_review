package actions.selenium

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class CSPWaitForElementNotPresent{
  public void run (def params){
  long startTime = System.currentTimeMillis()
  System.out.println("InTicks=" + (startTime % 100000)/1000 )
//   Browser.Driver.manage().timeouts().implicitlyWait(0, java.util.concurrent.TimeUnit.SECONDS)

   int count = params."Timeout In Seconds".toInteger() * 1000
    while(count >= 0){
      def elements = Elements.findAll(params,Browser.Driver)
      if(elements.size() == 0) break
      sleep(100)
      count = count - 100
    }
    //if(count > 0){
     // assert false,"Element was found in ${params."Timeout In Seconds"} seconds."
    //}
//   Browser.Driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS)
   long endTime = System.currentTimeMillis()
   System.out.println("OutTicks=" + (endTime % 100000)/1000 )
   System.out.println("====>Duration ="+ (endTime - startTime)/1000); System.out.println(" ")
}
}
