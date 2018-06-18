package CSPAF.CSPMultiTenant;

import java.util.*;

import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.multitenant.suites.controllers.*;

class WaitForCloneEnvironmentIDs
{
    public void run(HashMap<String, Object> params)
    {
        String productName = params.get("Product Name").toString();
        int timeout = Integer.parseInt(params.get("Timeout").toString());
        
        CSPCloneSuiteController controller = (CSPCloneSuiteController)CSPApplication.getWindowController().getNavigationController().getVisibleViewController();
        controller.getDetailsNotebookPage().waitForEnvironmentID(productName, timeout);
    }
}