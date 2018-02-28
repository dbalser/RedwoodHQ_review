package CSPAF.CSPMultiTenant;

import java.util.*;

import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.multitenant.suites.controllers.*;

class WaitForCloneActionMessage
{
    public void run(HashMap<String, Object> params)
    {
        int timeout = Integer.parseInt(params.get("Timeout").toString());
        String message = params.get("Message").toString();
        
        CSPCloneSuiteController controller=(CSPCloneSuiteController)CSPApplication.getWindowController().getNavigationController().getVisibleViewController();
        controller.getDetailsNotebookPage().waitForRecentActionMessage(message, timeout);
    }
}