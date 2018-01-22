package CSPAF.CSPMultiTenant;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.multitenant.controllers.*;
import com.infor.cloudsuite.multitenant.models.*;

class WaitForDatasourceProvisionStatus
{
    public void run(HashMap<String, Object> params)
    {
        String status = params.get("Status").toString();
        int timeout = Integer.parseInt(params.get("Timeout").toString());
        
        CSPCustomerEnvironmentsController controller=(CSPCustomerEnvironmentsController)CSPApplication.getWindowController().getNavigationController().getVisibleViewController();
        controller.waitForDatasourceProvisionStatus(status, timeout);
    }
}