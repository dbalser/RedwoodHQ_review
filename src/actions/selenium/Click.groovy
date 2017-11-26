package actions.selenium

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class Click{
  
  public void run(def params){
	long startTime = System.currentTimeMillis()
  	System.out.println("InTicks=" + (startTime % 100000)/1000 )
    WebElement element = Elements.find(params,Browser.Driver)
    //try catch is a workaround for a webdriver bug where element exists and visible but
    //webdriver is unable to click it
    int msTimeout = 30 * 1000  //Change by Frank Watts
    int msCountPerLoop = 100 //ms of time per loop
    while(msTimeout > 0)
    try{
      element.click()
	  long endTime = System.currentTimeMillis()
      System.out.println("OutTicks=" + (endTime % 100000)/1000 )
      System.out.println("====>Duration ="+ (endTime - startTime)/1000); System.out.println(" ")
      return
    }
    catch(org.openqa.selenium.WebDriverException err){
      msTimeout = msTimeout - msCountPerLoop
      System.out.println("++++>Caught Exception =" + err.message); 
      if (err.message.contains("Element is not clickable at point") ||
     	  err.message.contains("mg-busy-wait") ||
     	  err.message.contains("no such element") || //This may overcome refresh issues on mongoose autorefresh screens
          err.message.contains("element not visible")){
          if(msTimeout <= 0){
		  long endTime = System.currentTimeMillis()
          System.out.println("OutTicks=" + (endTime % 100000)/1000 )
          System.out.println("====>Duration ="+ (endTime - startTime)/1000); System.out.println(" ")
          throw err
        }
      }
      else{
    	long endTime = System.currentTimeMillis()
	    System.out.println("OutTicks=" + (endTime % 100000)/1000 )
        System.out.println("====>Duration ="+ (endTime - startTime)/1000); System.out.println(" ")
        throw err
      }
      sleep(msCountPerLoop) //fwatts change to 100 ms units.
    }
    long endTime = System.currentTimeMillis()
    System.out.println("OutTicks=" + (endTime % 100000)/1000 )
    System.out.println("====>Duration ="+ (endTime - startTime)/1000); System.out.println(" ")
    
  }
}