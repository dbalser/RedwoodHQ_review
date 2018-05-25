package CSPAF.CSPSingleTenant.gde;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;

class CSPGDEStopDemoTypeDeployment{
    public void run(HashMap<String, Object> params){
        
     CSPStopProdTypeDeploymentController controller = new CSPStopProdTypeDeploymentController();
     controller.stopDemoTypeDeployment();
        
    }
}