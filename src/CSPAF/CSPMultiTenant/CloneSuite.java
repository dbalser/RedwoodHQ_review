package CSPAF.CSPMultiTenant;

import java.util.*;

import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.multitenant.suites.models.*;
import com.infor.cloudsuite.portal.multitenant.environments.models.*;
import com.infor.cloudsuite.portal.multitenant.suites.controllers.*;

class CloneSuite
{
    public void run(HashMap<String, Object> params)
    {
        List<CSPTenant> tenants = new ArrayList<>();
        String customer = params.get("Customer").toString();
        String targetTenantType = params.get("Target Tenant Type").toString();
		List<String> applicationFarms = Arrays.asList(params.get("Application Farms").toString().split(","));
        List<String> dbAPIEndpoints =  Arrays.asList(params.get("DB API Endpoints").toString().split(","));
        List<String> tenantAPIEndpoints =  Arrays.asList(params.get("Tenant API Endpoints").toString().split(","));
        String scheduleDate = params.get("ScheduleDate").toString();
        String windowDropdown = params.get("Window").toString();

        for (int i = 0; i < applicationFarms.size(); i++)
        {
            CSPTenant tenant = new CSPTenant();
        	tenant.hostingGroup = params.get("Hosting group").toString();
        	tenant.applicationFarm = applicationFarms.get(i);
        	tenant.dbAPIEndpoint = dbAPIEndpoints.get(i);
        	tenant.tenantAPIEndpoint = tenantAPIEndpoints.get(i);
            tenants.add(tenant);
        }
        
        List<String> productNames = Arrays.asList(params.get("Product Names").toString().split(","));
        
        CSPCloneSuiteController controller =(CSPCloneSuiteController)CSPApplication.getWindowController().getNavigationController().getVisibleViewController();
        controller.cloneSuite(tenants, productNames,customer,targetTenantType,scheduleDate,windowDropdown);
    }
}