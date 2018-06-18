package CSPAF.CSPMultiTenant;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.multitenant.environments.controllers.*;

class WaitForTenantStatus{
    public void run(HashMap<String, Object> params){
     
        CSPCustomerEnvironmentsController controller=(CSPCustomerEnvironmentsController)CSPApplication.getWindowController().getNavigationController().getVisibleViewController();
     	controller.waitForTenantStatus();    
    }
}