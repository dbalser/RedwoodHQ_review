package CSPAF.CSPSingleTenant.gde;

import java.util.*;

import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;

class GDEActivateUserAndRegisterProducts
{
    public void run(HashMap<String, Object> params)
    {
        String activated = params.get("Activate").toString();    
        List<String> productNames = Arrays.asList(params.get("Product Names").toString().split(","));    

        CSPGDEUserController controller= new CSPGDEUserController();
        controller.activateGDEUser(activated, productNames); 
    }
}