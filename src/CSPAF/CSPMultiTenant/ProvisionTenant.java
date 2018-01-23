package CSPAF.CSPMultiTenant;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.multitenant.controllers.*;
import com.infor.cloudsuite.multitenant.models.*;

class ProvisionTenant
{
    public void run(HashMap<String, Object> params)
    {   
        CSPProductSuite productSuite = new CSPProductSuite();
        productSuite.environmentType = params.get("Environment Type").toString();
        productSuite.productSuite = params.get("Product Suite").toString();
        productSuite.productSuiteVersion = params.get("Product Suite Version").toString();
        
        List<CSPTenant> tenants = new ArrayList<>();
        List<String> applicationFarms = Arrays.asList(params.get("Application Farms").toString().split(","));
        List<String> dbAPIEndpoints =  Arrays.asList(params.get("DB API Endpoints").toString().split(","));
        List<String> tenantAPIEndpoints =  Arrays.asList(params.get("Tenant API Endpoints").toString().split(","));
        
        for (int i = 0; i < applicationFarms.size(); i++)
        {
            CSPTenant tenant = new CSPTenant();
        	tenant.hostingGroup = params.get("Hosting group").toString();
        	tenant.applicationFarm = applicationFarms.get(i);
        	tenant.dbAPIEndpoint = dbAPIEndpoints.get(i);
        	tenant.tenantAPIEndpoint = tenantAPIEndpoints.get(i);
        	tenant.adminEmails = params.get("Admin Emails").toString();
            tenants.add(tenant);
        }
        
        List<String> productNames = Arrays.asList(params.get("Product Names").toString().split(","));

        CSPCustomerController customer=(CSPCustomerController)CSPApplication.getWindowController().getNavigationController().getVisibleViewController();
        customer.provisionTenant(productSuite, tenants, productNames);
    }
}