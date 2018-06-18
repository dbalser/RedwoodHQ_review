package CSPAF.CSPCore.CSPServices;

import java.util.*;

import com.infor.cloudsuite.portal.core.services.*;

class CSPOpenBrowser
{
    public void run(HashMap<String, Object> params)
    {
        String url = params.get("URL").toString();
        String browserType = params.get("Browser Type").toString();
        CSPBrowser.to(url, browserType);
    }
}