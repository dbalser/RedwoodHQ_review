package CSPAF.CSPSingleTenant.gde;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.multitenant.suites.controllers.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;


class CSPGDEEmailUserActivate{
    public void run(HashMap<String, Object> params){
       
        String password = params.get("Password").toString();
        String loginEmail = params.get("LoginEmail").toString();
        String loginPassword = params.get("LoginPassword").toString();
        String confirmPassword = params.get("Confirm Password").toString();

        /*CSPActivateGDEEmailUserAndCreatePasswordController controller= new CSPActivateGDEEmailUserAndCreatePasswordController();
        controller.checkEmail(emailId);
        this is for mailinator email automation, now changing it to gmail*/
        
        /*CSPGDEMailinatorLandingPageController pagecontroller=new CSPGDEMailinatorLandingPageController();
        pagecontroller.activateAccount();*/
        
        CSPGmailVerifyEmailController controller=new CSPGmailVerifyEmailController();
        controller.gdeUserActivation(loginEmail,loginPassword);
        
        CSPGDEPasswordCreationController passwordcontroller=new CSPGDEPasswordCreationController();
        passwordcontroller.createPassword(password,confirmPassword);
        
        CSPGDERedirectToLoginPageController redirectcontroller=new CSPGDERedirectToLoginPageController();
        redirectcontroller.getRedirectToLoginButton().click();
    }
    
}