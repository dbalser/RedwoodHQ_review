package CSPAF.CSPMultiTenant;

import java.util.*;

import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.multitenant.controllers.*;
import com.infor.cloudsuite.multitenant.models.*;

class WaitForEnvironmentIDs
{
    public void run(HashMap<String, Object> params)
    {
        int timeout = Integer.parseInt(params.get("Timeout").toString());
        
        CSPSuitesController controller=(CSPSuitesController)CSPApplication.getWindowController().getNavigationController().getVisibleViewController();
        controller.getDetailsNotebookPage().waitForEnvironmentIDs(timeout);
    }
}