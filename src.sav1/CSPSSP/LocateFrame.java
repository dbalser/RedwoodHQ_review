package CSPSSP;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;

import actions.selenium.Browser;

class LocateFrame{
   public String run(HashMap<String, Object> Params)
 {
      
            String htmlAttribute = Params.get("Html Attribute").toString();
            String htmlAttributeValue = Params.get("Html Attribute Value").toString();
            WebElement frame = Browser.Driver.findElement(By.xpath("//iframe[@" + htmlAttribute + "='" + htmlAttributeValue + "']"));
            
            return frame.getAttribute("name");
}
}