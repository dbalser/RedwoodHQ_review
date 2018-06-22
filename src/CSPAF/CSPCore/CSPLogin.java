package CSPAF.CSPCore;

import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;

import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.core.controllers.CSPAuthenticationController;

class CSPLogin
{
    public void run(HashMap<String, Object> params)
    {
        String username = params.get("Username").toString();
        String password = params.get("Password").toString();
        
        CSPAuthenticationController controller = new CSPAuthenticationController();
        
        WebDriverWait wait = new WebDriverWait(CSPApplication.getWebDriver(), 30);
        wait.withMessage(controller.getClass().toString() + "(" + controller.getView().getXPath() + ") is not visible");
        wait.until(ExpectedConditions.visibilityOfElementLocated(controller.getView().getLocator()));
        
        controller.login(username, password);
    }
}