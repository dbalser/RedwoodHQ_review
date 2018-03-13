package CSPAF.CSPMultiTenant;

import java.util.*;

import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.multitenant.environments.controllers.*;

class ActivateDatasourceProvisionStatus
{
    public void run(HashMap<String, Object> params)
    {
        String status = params.get("Status").toString();
        int timeout = Integer.parseInt(params.get("Timeout").toString());
        String dbEndPoint = params.get("DBEndPoint").toString();

        
        CSPCustomerEnvironmentActivationController controller=(CSPCustomerEnvironmentActivationController)CSPApplication.getWindowController().getNavigationController().getVisibleViewController();
        controller.activateDatasourceProvisionStatus(status, timeout,dbEndPoint);
    }
}