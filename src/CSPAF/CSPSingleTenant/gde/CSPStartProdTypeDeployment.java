package CSPAF.CSPSingleTenant.gde;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;


class CSPStartProdTypeDeployment{
    public void run(HashMap<String, Object> params){
       String startInput = params.get("Start Input").toString();
   
        CSPStopProdTypeDeploymentController controller = new CSPStopProdTypeDeploymentController();
        controller.startDeploymentWizard(startInput);    
    }
}