package CSPAF.CSPMultiTenant;

import java.util.*;

import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.multitenant.environments.controllers.*;

class ActivateTenantProvisionStatus
{
    public void run(HashMap<String, Object> params)
    {
        String status = params.get("Status").toString();
        int timeout = Integer.parseInt(params.get("Timeout").toString());
        
        CSPCustomerEnvironmentActivationController controller=(CSPCustomerEnvironmentActivationController)CSPApplication.getWindowController().getNavigationController().getVisibleViewController();
        controller.activateTenantProvisionStatus(status, timeout);
    }
}