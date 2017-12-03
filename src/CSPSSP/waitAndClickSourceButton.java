package CSPSSP;

import java.util.*;
import actions.selenium.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class waitAndClickSourceButton{
    public void run(HashMap<String, Object> params){
        WebDriverWait Wait = new WebDriverWait(Browser.Driver, 120);
        WebElement SourceButton = Browser.Driver.findElement(By.xpath("//a[@title='Source']"));
        //Wait.until(ExpectedConditions.visibilityOfElementLocated(SourceButton));
        Wait.until(ExpectedConditions.elementToBeClickable(SourceButton));
        SourceButton.click();
        
        WebElement textField = Browser.Driver.findElement(By.xpath("//textarea[@aria-label='Rich text editor, ckeditorArea']"));
        textField.sendKeys("Hello Test");
        
    }
}