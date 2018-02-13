package CSPAF.CSPMultiTenant;

import java.util.*;

import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.multitenant.suites.controllers.*;

class VerifyCloneCustomerEnvironments
{
    public void run(HashMap<String, Object> params)
    {
        String productName = params.get("Product Name").toString();
    	String tenantStatus = params.get("Tenant Status").toString();
        int timeout = Integer.parseInt(params.get("Timeout").toString());
        
        CSPCloneSuiteController controller=(CSPCloneSuiteController)CSPApplication.getWindowController().getNavigationController().getVisibleViewController();
        controller.verifyCloneCustomerEnvironment(productName, tenantStatus, timeout);
    }
}