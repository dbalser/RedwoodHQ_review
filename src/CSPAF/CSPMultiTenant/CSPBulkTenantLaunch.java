package CSPAF.CSPMultiTenant;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.core.helpers.*;
import com.infor.cloudsuite.portal.multitenant.environments.controllers.*;
import com.infor.cloudsuite.portal.multitenant.environments.models.*;
import com.infor.cloudsuite.portal.core.controllers.CSPAuthenticationController;
import com.infor.cloudsuite.portal.core.controllers.CSPMessageBoxController;
import com.infor.cloudsuite.portal.core.controllers.CSPViewController;
import com.infor.cloudsuite.portal.core.mongoose.CSPMongooseConstants;
import com.infor.cloudsuite.portal.core.services.CSPBrowser;
import com.infor.cloudsuite.portal.core.views.*;
import com.infor.cloudsuite.portal.multitenant.environments.models.CSPWizard;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;


class CSPBulkTenantLaunch{
    public void run(HashMap<String, Object> params){
       
        CSPBulkTenantLaunchController controller=new CSPBulkTenantLaunchController();
        controller.wizardProvisioning(new CSPWizard());
        //"CSPQA-Automation-MTReg-Ming.le-12.0","Regression0614","AX1","CSPQA-Automation-DB-Endpoint","CSPQA-Automation-TP-Endpoint","Pradeep.podishetti@infor.com"
    }
}

