package actions.selenium

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys

class CSPSetText{
  
  public static void run(def params){
	def retriesRemaining = 20
    while (retriesRemaining-- >= 0) {      
        try {
	        WebElement element = Elements.find(params,Browser.Driver)
            element.clear()
            element.sendKeys(params."Text")
			return            
        }
        catch(org.openqa.selenium.WebDriverException err){
            sleep(1000)
            if (retriesRemaining <= 1) throw err
        }
    }   
  }
}