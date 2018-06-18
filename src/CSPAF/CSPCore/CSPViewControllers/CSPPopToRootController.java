package CSPAF.CSPCore.CSPViewControllers;

import java.util.*;

import com.infor.cloudsuite.portal.core.services.*;

class CSPPopToRootController
{
    public void run(HashMap<String, Object> params) {
        CSPBrowser.getApplication().getWindowController().getNavigationController().popToRootViewController();
    }
}