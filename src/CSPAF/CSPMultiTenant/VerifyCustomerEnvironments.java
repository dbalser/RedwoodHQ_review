package CSPAF.CSPMultiTenant;

import java.util.*;

import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.multitenant.suites.controllers.*;

class VerifyCustomerEnvironments
{
    public void run(HashMap<String, Object> params)
    {
        String productName = params.get("Product Name").toString();
        String datasourceStatus = params.get("Datasource Status").toString();
        String tenantStatus = params.get("Tenant Status").toString();
        int timeout = Integer.parseInt(params.get("Timeout").toString());
        
        CSPSuitesController controller=(CSPSuitesController)CSPApplication.getWindowController().getNavigationController().getVisibleViewController();
        controller.verifyCustomerEnvironment(productName, datasourceStatus, tenantStatus, timeout);
    }
}