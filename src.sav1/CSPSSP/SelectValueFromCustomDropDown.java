package CSPSSP;
import actions.selenium.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import java.util.*;
public class SelectValueFromCustomDropDown {
     public void run(HashMap<String, Object> params) {
         
         WebElement element= null;
         String elementText = params.get("Text").toString();
         element = Browser.Driver.findElement(By.xpath(".//a[@role='option'][contains(text(),'"+elementText+"')]")); 
         element.click();
   
     }
}