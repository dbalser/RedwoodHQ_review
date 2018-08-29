package CSPAF.CSPSingleTenant.gde;

import java.util.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;
import com.infor.cloudsuite.portal.core.*;
import org.openqa.selenium.By;
import java.util.*;

class CSPSetDeploymentStatusDropdown{
    public void run(HashMap<String, Object> params){
         String deploymentStatus = params.get("DeploymentStatus").toString();
        
         CSPStopProdTypeDeploymentController controller = new CSPStopProdTypeDeploymentController();
         controller.setDeploymentDropdown(deploymentStatus);
   
    }
}