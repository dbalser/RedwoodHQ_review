package CSPAF.CSPCore;

import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import com.infor.cloudsuite.portal.core.*;

class CSPSetEnvironment
{
    public void run(HashMap<String, Object> params)
    {
        String environment = params.get("Environment").toString();
        
        WebDriverWait wait = new WebDriverWait(CSPApplication.getWebDriver(), 30);
        
        By environmentDropdownLocator = By.xpath("//input[@id='configCombo-inputEl']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(environmentDropdownLocator));
        
        WebElement environmentDropdown = CSPApplication.getWebDriver().findElement(environmentDropdownLocator);
        environmentDropdown.clear();
        environmentDropdown.sendKeys(environment);
        
        By signInButtonLocator = By.xpath("//a[@id='signinBtn']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInButtonLocator));
        
        WebElement signInButton = CSPApplication.getWebDriver().findElement(signInButtonLocator);
        signInButton.click();
    }
}