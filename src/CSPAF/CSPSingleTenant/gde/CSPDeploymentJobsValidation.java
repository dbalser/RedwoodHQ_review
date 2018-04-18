package CSPAF.CSPSingleTenant.gde;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;

class CSPDeploymentJobsValidation{
    public void run(HashMap<String, Object> params){
        
     CSPDeploymentJobsController controller = new CSPDeploymentJobsController();
     controller.deploymentJobVerify();
        
    }
}