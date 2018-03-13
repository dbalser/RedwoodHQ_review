package CSPAF.CSPMultiTenant;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.multitenant.suites.controllers.*;
import com.infor.cloudsuite.portal.multitenant.environments.controllers.*;

class GmailVerifyEmail{
    public void run(HashMap<String, Object> params){
        String email = params.get("Email").toString();
        String password = params.get("Password").toString();
        
        CSPGmailVerifyEmailController controller=new CSPGmailVerifyEmailController();
        controller.gmailVerifyEmail(email, password);
   
    }
}