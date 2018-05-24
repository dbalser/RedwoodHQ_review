package CSPAF.CSPSingleTenant.gde;

import java.util.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;
import com.infor.cloudsuite.portal.core.*;
import org.openqa.selenium.By;

class CSPDeleteWhitelistIps{
    public void run(HashMap<String, Object> params){
        
     CSPManageWhitelistIpsController controller = new CSPManageWhitelistIpsController();
     controller.deleteWhitelistIps();
        
    }
}