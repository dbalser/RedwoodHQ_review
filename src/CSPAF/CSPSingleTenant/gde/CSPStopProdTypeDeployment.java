package CSPAF.CSPSingleTenant.gde;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;

class CSPStopProdTypeDeployment{
    public void run(HashMap<String, Object> params){
      String stopInput = params.get("Stop Input").toString();
   
        CSPStopProdTypeDeploymentController controller = new CSPStopProdTypeDeploymentController();
        controller.stopDeploymentWizard(stopInput);  
    }
}