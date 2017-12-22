package CSPAF.CSPCore.CSPNavigation;

import java.util.*;

import com.infor.cloudsuite.portal.core.views.*;
import com.infor.cloudsuite.portal.core.services.*;

class CSPClickNavigationItem
{
    public void run(HashMap<String, Object> params)
    {
        String text = params.get("Text").toString();
        CSPNavigationBar navigationBar = CSPBrowser.getApplication().getWindowController().getNavigationBar();
        navigationBar.click(text);
    }
}