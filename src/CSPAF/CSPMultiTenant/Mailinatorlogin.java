package CSPAF.CSPMultiTenant;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;


class Mailinatorlogin{
    public void run(HashMap<String, Object> params){
        String emailId = params.get("EmailId").toString();
       
        CSPActivateGDEEmailUserAndCreatePasswordController controller= new CSPActivateGDEEmailUserAndCreatePasswordController();
        controller.checkEmail(emailId);
        
    }
    
}