package CSPAF.CSPMultiTenant;

import java.util.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;
import com.infor.cloudsuite.portal.core.*;
import org.openqa.selenium.By;

class CSPGDELogin{
    public void run(HashMap<String, Object> params){
            String username = params.get("Username").toString();
    		String password = params.get("Password").toString();

        CSPGDEAuthenticationController controller=new CSPGDEAuthenticationController();
        controller.login(username,password);
    }
}