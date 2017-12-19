package CSPAF.CSPCore.CSPServices;

import java.util.*;

import com.infor.cloudsuite.portal.core.services.*;

class CSPCloseBrowser
{
    public void run(HashMap<String, Object> params)
    {
        try
        {
            CSPBrowser.getApplication().getWebDriver().close();
           	CSPBrowser.getApplication().getWebDriver().quit();
        }
        catch (Exception e) {}
    }
}