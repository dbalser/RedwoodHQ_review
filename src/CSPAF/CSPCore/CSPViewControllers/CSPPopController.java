package CSPAF.CSPCore.CSPViewControllers;

import java.util.*;

import com.infor.cloudsuite.portal.core.services.*;

class CSPPopController
{
    public void run(HashMap<String, Object> params) {
        CSPBrowser.getApplication().getWindowController().getNavigationController().pop();
    }
}