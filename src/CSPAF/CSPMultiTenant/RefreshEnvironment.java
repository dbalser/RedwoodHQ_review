package CSPAF.CSPMultiTenant;
import com.infor.cloudsuite.portal.multitenant.suites.controllers.*;
import com.infor.cloudsuite.portal.core.CSPApplication;
import com.infor.cloudsuite.portal.core.controllers.CSPViewController;
import com.infor.cloudsuite.portal.core.views.CSPButton;
import org.openqa.selenium.By;
import java.util.*;

class RefreshEnvironment{
    public void run(HashMap<String, Object> params){
        String sourceCustomer = params.get("SourceCustomer").toString();
        String sourceType = params.get("SourceType").toString();
        String customer = params.get("Customer").toString();
	    String product = params.get("Product").toString();
	    String type = params.get("Type").toString();
	    String dateInput = params.get("DateInput").toString();
        String newDate = params.get("NewDate").toString();
      
        CSPSSPRefreshEnvironmentController controller= new CSPSSPRefreshEnvironmentController();
   		controller.refresh(customer,product,type);
        
        CSPSSPRefreshEnvironmentTemplateController refreshcontroller= new CSPSSPRefreshEnvironmentTemplateController();
   		refreshcontroller.refreshEnvironment(dateInput,sourceCustomer,sourceType,newDate);
        
        
   }
}