package CSPSSP; 
import actions.selenium.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import java.util.*;

class GetAttribute{
    public String run(HashMap<String, Object> params){
        
         WebElement element= null;
         if(params.get("ID Type").toString().equals("ID"))
         {
            element = Browser.Driver.findElement(By.id(params.get("ID").toString())); 
         }
         else if(params.get("ID Type").toString().equals("Xpath"))
         {
             element = Browser.Driver.findElement(By.xpath(params.get("ID").toString()));
         }
         
         else if(params.get("ID Type").toString().equals("Class Name"))
         {
             element = Browser.Driver.findElement(By.className(params.get("ID").toString()));
         }
         else if(params.get("ID Type").toString().equals("Tag Name"))
         {
             element = Browser.Driver.findElement(By.tagName(params.get("ID").toString()));
         }
         else
         {
             element = Browser.Driver.findElement(By.name(params.get("ID").toString())); 
         }
 
        
        return element.getAttribute(params.get("AttributeType").toString());
    }
}