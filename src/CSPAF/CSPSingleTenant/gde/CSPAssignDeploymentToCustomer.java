package CSPAF.CSPSingleTenant.gde;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;

class CSPAssignDeploymentToCustomer{
    public void run(HashMap<String, Object> params){
    String customerInput = params.get("Customer Input").toString();
         
        CSPGDEProdTypeDeploymentLaunchController controller = new CSPGDEProdTypeDeploymentLaunchController();
        controller.assignDeploymentToCustomer(customerInput); 
             
    }
}