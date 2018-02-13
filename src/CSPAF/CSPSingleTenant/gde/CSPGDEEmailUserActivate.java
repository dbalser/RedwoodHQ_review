package CSPAF.CSPSingleTenant.gde;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;


class CSPGDEEmailUserActivate{
    public void run(HashMap<String, Object> params){
        String emailId = params.get("EmailId").toString();
        String password = params.get("Password").toString();
        String confirmPassword = params.get("Confirm Password").toString();

        CSPActivateGDEEmailUserAndCreatePasswordController controller= new CSPActivateGDEEmailUserAndCreatePasswordController();
        controller.checkEmail(emailId);
        
        CSPGDEMailinatorLandingPageController pagecontroller=new CSPGDEMailinatorLandingPageController();
        pagecontroller.activateAccount();
        
        CSPGDEPasswordCreationController passwordcontroller=new CSPGDEPasswordCreationController();
        passwordcontroller.createPassword(password,confirmPassword);
        
        CSPGDERedirectToLoginPageController redirectcontroller=new CSPGDERedirectToLoginPageController();
        redirectcontroller.getRedirectToLoginButton().click();
    }
    
}