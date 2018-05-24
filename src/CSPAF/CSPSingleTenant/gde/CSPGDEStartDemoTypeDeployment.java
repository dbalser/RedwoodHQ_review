package CSPAF.CSPSingleTenant.gde;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;

class CSPGDEStartDemoTypeDeployment{
    public void run(HashMap<String, Object> params){
     String hours = params.get("Hours").toString();
     String timeZone = params.get("TimeZone").toString();
     
     CSPStopProdTypeDeploymentController controller = new CSPStopProdTypeDeploymentController();
     controller.startDemoTypeDeployment(hours,timeZone);
    }
}