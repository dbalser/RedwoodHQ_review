package CSPAF.CSPSingleTenant.gde;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;

class CSPAuthorizeUsersForDeployment{
    public void run(HashMap<String, Object> params){
     String userEmail = params.get("User Email").toString();
        
     CSPGDEProdTypeDeploymentLaunchController controller = new CSPGDEProdTypeDeploymentLaunchController();
     controller.authorizeUserSelectionForDeployment(userEmail);

        
    }
}