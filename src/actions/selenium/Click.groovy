package actions.selenium

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class Click{
  
  public void run(def params){
	long startTime = System.currentTimeMillis()
  	System.out.println("InTicks=" + (startTime % 100000)/1000 )
    int msTimeout = 30 * 1000  //Change by Frank Watts
    int msCountPerLoop = 100 //ms of time per loop
    //try catch is a workaround for a webdriver bug where element exists and visible but
    //webdriver is unable to click it
	def failCount = 0;
    while(msTimeout > 0) {
        try{
          WebElement element = Elements.find(params,Browser.Driver)
          element.click()
          long endTime = System.currentTimeMillis()
          System.out.println("OutTicks=" + (endTime % 100000)/1000 )
          System.out.println("====>Duration ="+ (endTime - startTime)/1000); System.out.println(" ")
          return
        }
        catch(org.openqa.selenium.WebDriverException err){
          failCount += 1;
          System.out.println("++++>Caught Exception =" + err.message); 
		  def retriableError = false
          if (err.message.contains("Element is not clickable at point") ||
              err.message.contains("mg-busy-wait") ||
              err.message.contains("no such session") || 
              err.message.contains("no such element") || //This may overcome refresh issues on mongoose autorefresh screens
              err.message.contains("element not visible")) {
			  retriableError = true
          }
           
          if ((msTimeout <= 200) || (failCount > 100) || !(retriableError)){
              long endTime = System.currentTimeMillis()
              System.out.println("OutTicks=" + (endTime % 100000)/1000 )
              System.out.println("====>Duration ="+ (endTime - startTime)/1000); System.out.println(" ")
              throw err
          }
         sleep(1000) //after an exception, sleep longer
         msTimeout = msTimeout - 1000
        }
        sleep(msCountPerLoop) //fwatts change to 100 ms units.
        msTimeout = msTimeout - msCountPerLoop
    } 
    long endTime = System.currentTimeMillis()  //If you make it this far, the click failed.  Create an error.
    System.out.println("OutTicks=" + (endTime % 100000)/1000 )
    System.out.println("====>Duration ="+ (endTime - startTime)/1000); System.out.println(" ")
    assert false, "Could not click on element"
  }
}