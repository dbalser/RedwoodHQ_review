package CSPAF.CSPSingleTenant.gde;


import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;

class CSPRestartProdTypeDeployment{
    public void run(HashMap<String, Object> params){
     String restartInput = params.get("Restart Input").toString();
   
        CSPStopProdTypeDeploymentController controller = new CSPStopProdTypeDeploymentController();
        controller.restartDeploymentWizard(restartInput);
    }
}