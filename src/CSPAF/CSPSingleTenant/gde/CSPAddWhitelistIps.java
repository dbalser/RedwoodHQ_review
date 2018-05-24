package CSPAF.CSPSingleTenant.gde;

import java.util.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;
import com.infor.cloudsuite.portal.core.*;
import org.openqa.selenium.By;


class CSPAddWhitelistIps{
    public void run(HashMap<String, Object> params){
    String whitelistDescription = params.get("Whitelist Description").toString();
        
     CSPManageWhitelistIpsController controller = new CSPManageWhitelistIpsController();
     controller.addWhitelistIps(whitelistDescription);
  
    }
}