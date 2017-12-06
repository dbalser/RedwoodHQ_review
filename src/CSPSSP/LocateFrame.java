package CSPSSP;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import actions.selenium.Browser;

class LocateFrame
{
    //test
   public String run(HashMap<String, Object> Params)
   {
      String htmlAttribute = Params.get("Html Attribute").toString();
      String htmlAttributeValue = Params.get("Html Attribute Value").toString();
       
      By frameXPath = By.xpath("//iframe[contains(@" + htmlAttribute + ", '" + htmlAttributeValue + "')]");
       
      WebDriverWait wait = new WebDriverWait(Browser.Driver, 120);
      wait.until(ExpectedConditions.visibilityOfElementLocated(frameXPath));
      
      return Browser.Driver.findElement(frameXPath).getAttribute("name");
   }
}