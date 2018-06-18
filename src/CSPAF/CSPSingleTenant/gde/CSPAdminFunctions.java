package CSPAF.CSPSingleTenant.gde;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;


class CSPAdminFunctions{
    public void run(HashMap<String, Object> params){
     String searchValue = params.get("Search Value").toString();
     String confirmInput = params.get("Confirm Input").toString();
     
     CSPAdminFunctionsController controller = new CSPAdminFunctionsController();
     controller.launchAdminFunction(searchValue,confirmInput);   
    }
}